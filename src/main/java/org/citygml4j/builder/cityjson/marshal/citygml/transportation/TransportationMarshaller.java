/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.cityjson.marshal.citygml.transportation;

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.SemanticSurfaceCollector;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.feature.AbstractTransportationComplexType;
import org.citygml4j.cityjson.feature.RailwayType;
import org.citygml4j.cityjson.feature.RoadType;
import org.citygml4j.cityjson.feature.TransportSquareType;
import org.citygml4j.cityjson.feature.TransportationComplexAttributes;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.MultiLineStringType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.transportation.AbstractTransportationObject;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TransportationMarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> typeMapper;

	public TransportationMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();
	}

	private BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObjectType>create()
							.with(Road.class, this::marshalRoad)
							.with(Railway.class, this::marshalRailway)
							.with(Square.class, this::marshalSquare);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public AbstractCityObjectType marshal(ModelObject src, CityJSON cityJSON) {
		return getTypeMapper().apply(src, cityJSON);
	}

	public SemanticsType marshalSemantics(AbstractCityObject cityObject) {
		SemanticsType semantics = null;

		if (cityObject instanceof TrafficArea) {
			semantics = new SemanticsType("TrafficArea");
			marshalTrafficArea((TrafficArea)cityObject, semantics);
		} else if (cityObject instanceof AuxiliaryTrafficArea) {
			semantics = new SemanticsType("AuxiliaryTrafficArea");
			marshalAuxiliaryTrafficArea((AuxiliaryTrafficArea)cityObject, semantics);
		}

		if (semantics != null)
			citygml.getGenericsMarshaller().marshalSemanticSurfaceAttributes(cityObject, semantics);

		return semantics;
	}

	public void marshalAbstractTransportationObject(AbstractTransportationObject src, AbstractCityObjectType dest, CityJSON cityJSON) {
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, cityJSON);

		if (src.isSetGenericApplicationPropertyOfTransportationObject())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfTransportationObject(), dest, cityJSON);
	}
	
	public void marshalTransportationComplex(TransportationComplex src, AbstractTransportationComplexType dest, CityJSON cityJSON) {
		marshalAbstractTransportationObject(src, dest, cityJSON);

		TransportationComplexAttributes attributes = dest.getAttributes();
		if (src.isSetClazz())
			attributes.setClazz(src.getClazz().getValue());

		if (src.isSetFunction()) {
			for (Code function : src.getFunction()) {
				if (function.isSetValue()) {
					attributes.setFunction(function.getValue());
					break;
				}
			}
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage()) {
				if (usage.isSetValue()) {
					attributes.setUsage(usage.getValue());
					break;
				}
			}
		}
		
		if (src.isSetTrafficArea()) {
			for (TrafficAreaProperty property : src.getTrafficArea()) {
				if (property.isSetTrafficArea() && property.getTrafficArea().isSetSurfaceMaterial()) {
					Code surfaceMaterial = property.getTrafficArea().getSurfaceMaterial();
					if (surfaceMaterial.isSetValue())
						attributes.addSurfaceMaterial(surfaceMaterial.getValue());
				}
			}
		}
		
		if (src.isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaProperty property : src.getAuxiliaryTrafficArea()) {
				if (property.isSetAuxiliaryTrafficArea() && property.getAuxiliaryTrafficArea().isSetSurfaceMaterial()) {
					Code surfaceMaterial = property.getAuxiliaryTrafficArea().getSurfaceMaterial();
					if (surfaceMaterial.isSetValue())
						attributes.addSurfaceMaterial(surfaceMaterial.getValue());
				}
			}
		}

		if (src.isSetGenericApplicationPropertyOfTransportationComplex())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfTransportationComplex(), dest, cityJSON);

		SemanticSurfaceCollector collector = null;
		if (src.isSetTrafficArea() || src.isSetAuxiliaryTrafficArea())
			collector = preprocessGeometry(src);

		if (src.isSetLod0Network()) {
			MultiLineStringType geometry = json.getGMLMarshaller().marshalMultiLineString(src.getLod0Network());
			if (geometry != null) {
				geometry.setLod(0);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod1MultiSurface()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiSurface());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod2MultiSurface()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2MultiSurface());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod3MultiSurface()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3MultiSurface());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}

		if (collector != null)
			postprocessGeometry(src, collector);
	}

	public void marshalRoad(Road src, RoadType dest, CityJSON cityJSON) {
		marshalTransportationComplex(src, dest, cityJSON);

		if (src.isSetGenericApplicationPropertyOfRoad())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfRoad(), dest, cityJSON);
	}
	
	public RoadType marshalRoad(Road src, CityJSON cityJSON) {
		RoadType dest = new RoadType();
		marshalRoad(src, dest, cityJSON);
		
		return dest;
	}

	public void marshalRailway(Railway src, RailwayType dest, CityJSON cityJSON) {
		marshalTransportationComplex(src, dest, cityJSON);

		if (src.isSetGenericApplicationPropertyOfRailway())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfRailway(), dest, cityJSON);
	}
	
	public RailwayType marshalRailway(Railway src, CityJSON cityJSON) {
		RailwayType dest = new RailwayType();
		marshalRailway(src, dest, cityJSON);
		
		return dest;
	}

	public void marshalSquare(Square src, TransportSquareType dest, CityJSON cityJSON) {
		marshalTransportationComplex(src, dest, cityJSON);

		if (src.isSetGenericApplicationPropertyOfSquare())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfSquare(), dest, cityJSON);
	}
	
	public TransportSquareType marshalSquare(Square src, CityJSON cityJSON) {
		TransportSquareType dest = new TransportSquareType();
		marshalSquare(src, dest, cityJSON);
		
		return dest;
	}

	private void marshalTrafficArea(TrafficArea src, SemanticsType dest) {
		if (src.isSetClazz())
			dest.addAttribute("class", src.getClazz().getValue());

		if (src.isSetFunction()) {
			for (Code function : src.getFunction()) {
				if (function.isSetValue()) {
					dest.addAttribute("function", function.getValue());
					break;
				}
			}
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage()) {
				if (usage.isSetValue()) {
					dest.addAttribute("usage", usage.getValue());
					break;
				}
			}
		}

		if (src.isSetSurfaceMaterial())
			dest.addAttribute("surfaceMaterial", src.getSurfaceMaterial().getValue());
	}

	private void marshalAuxiliaryTrafficArea(AuxiliaryTrafficArea src, SemanticsType dest) {
		if (src.isSetClazz())
			dest.addAttribute("class", src.getClazz().getValue());

		if (src.isSetFunction()) {
			for (Code function : src.getFunction()) {
				if (function.isSetValue()) {
					dest.addAttribute("function", function.getValue());
					break;
				}
			}
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage()) {
				if (usage.isSetValue()) {
					dest.addAttribute("usage", usage.getValue());
					break;
				}
			}
		}

		if (src.isSetSurfaceMaterial())
			dest.addAttribute("surfaceMaterial", src.getSurfaceMaterial().getValue());
	}

	private SemanticSurfaceCollector preprocessGeometry(TransportationComplex src) {
		List<FeatureProperty<?>> properties = new ArrayList<>(src.getTrafficArea());
		properties.addAll(src.getAuxiliaryTrafficArea());

		SemanticSurfaceCollector collector = new SemanticSurfaceCollector();
		collector.collectSurfaces(properties, 2, 3);

		for (int lod = 2; lod < 4; lod++) {
			if (collector.hasSurfaces(lod)) {
				if (lod == 2)
					collector.assignSurfaces(src::getLod2MultiSurface, src::setLod2MultiSurface, lod);
				else
					collector.assignSurfaces(src::getLod3MultiSurface, src::setLod3MultiSurface, lod);
			}
		}

		return collector;
	}

	private void postprocessGeometry(TransportationComplex src, SemanticSurfaceCollector collector) {
		for (int lod = 2; lod < 4; lod++) {
			if (collector.hasSurfaces(lod)) {
				if (lod == 2)
					collector.clean(src::getLod2MultiSurface, src::unsetLod2MultiSurface);
				else
					collector.clean(src::getLod3MultiSurface, src::unsetLod3MultiSurface);
			}
		}
	}

}
