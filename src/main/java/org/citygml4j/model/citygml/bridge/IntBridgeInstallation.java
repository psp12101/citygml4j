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
package org.citygml4j.model.citygml.bridge;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class IntBridgeInstallation extends AbstractCityObject implements BridgeModuleComponent, StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private GeometryProperty<? extends AbstractGeometry> lod4Geometry;
	private ImplicitRepresentationProperty lod4ImplicitRepresentation;
	private List<BoundarySurfaceProperty> boundedBySurface;
	private List<ADEComponent> ade;

	public IntBridgeInstallation() {
		
	}
	
	public IntBridgeInstallation(Module module) {
		super(module);
	}
	
	public ImplicitRepresentationProperty getLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation;
	}
	
	public boolean isSetLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation != null;
	}
	
	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
		this.lod4ImplicitRepresentation = ModelObjects.setParent(lod4ImplicitRepresentation, this);
	}
	
	public void unsetLod4ImplicitRepresentation() {
		lod4ImplicitRepresentation = ModelObjects.setNull(lod4ImplicitRepresentation);
	}
	
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		getBoundedBySurface().add(boundedBySurface);
	}
	
	public List<BoundarySurfaceProperty> getBoundedBySurface() {
		if (boundedBySurface == null)
			boundedBySurface = new ChildList<>(this);

		return boundedBySurface;
	}
	
	public boolean isSetBoundedBySurface() {
		return boundedBySurface != null && !boundedBySurface.isEmpty();
	}
	
	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface) {
		this.boundedBySurface = new ChildList<>(this, boundedBySurface);
	}
	
	public void unsetBoundedBySurface() {
		boundedBySurface = ModelObjects.setNull(boundedBySurface);
	}

	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		return isSetBoundedBySurface() && this.boundedBySurface.remove(boundedBySurface);
	}
	
	public void addFunction(Code function) {
		getFunction().add(function);
	}
	
	public void addUsage(Code usage) {
		getUsage().add(usage);
	}

	public void addGenericApplicationPropertyOfIntBridgeInstallation(ADEComponent ade) {
		getGenericApplicationPropertyOfIntBridgeInstallation().add(ade);
	}

	public Code getClazz() {
		return clazz;
	}

	public List<Code> getFunction() {
		if (function == null)
			function = new ChildList<>(this);

		return function;
	}
	
	public List<Code> getUsage() {
		if (usage == null)
			usage = new ChildList<>(this);

		return usage;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfIntBridgeInstallation() {
		if (ade == null)
			ade = new ChildList<>(this);

		return ade;
	}

	public GeometryProperty<? extends AbstractGeometry> getLod4Geometry() {
		return lod4Geometry;
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}
	
	public boolean isSetUsage() {
		return usage != null && !usage.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfIntBridgeInstallation() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod4Geometry() {
		return lod4Geometry != null;
	}

	public void setClazz(Code clazz) {
		this.clazz = ModelObjects.setParent(clazz, this);
	}

	public void setFunction(List<Code> function) {
		this.function = new ChildList<>(this, function);
	}
	
	public void setUsage(List<Code> usage) {
		this.usage = new ChildList<>(this, usage);
	}

	public void setGenericApplicationPropertyOfIntBridgeInstallation(List<ADEComponent> ade) {
		this.ade = new ChildList<>(this, ade);
	}

	public void setLod4Geometry(GeometryProperty<? extends AbstractGeometry> lod4Geometry) {
		this.lod4Geometry = ModelObjects.setParent(lod4Geometry, this);
	}

	public void unsetClazz() {
		clazz = ModelObjects.setNull(clazz);
	}

	public void unsetFunction() {
		function = ModelObjects.setNull(function);
	}

	public boolean unsetFunction(Code function) {
		return isSetFunction() && this.function.remove(function);
	}
	
	public void unsetUsage() {
		usage = ModelObjects.setNull(usage);
	}

	public boolean unsetUsage(Code usage) {
		return isSetUsage() && this.usage.remove(usage);
	}

	public void unsetGenericApplicationPropertyOfIntBridgeInstallation() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfIntBridgeInstallation(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfIntBridgeInstallation() && this.ade.remove(ade);
	}

	public void unsetLod4Geometry() {
		lod4Geometry = ModelObjects.setNull(lod4Geometry);
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INT_BRIDGE_INSTALLATION;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetLod4Geometry()) {
			if (lod4Geometry.isSetGeometry()) {
				boundedBy.updateEnvelope(lod4Geometry.getGeometry().calcBoundingBox());			
			} else {
				// xlink
			}
		}
		
		if (isSetLod4ImplicitRepresentation() && lod4ImplicitRepresentation.isSetImplicitGeometry())
			boundedBy.updateEnvelope(lod4ImplicitRepresentation.getImplicitGeometry().calcBoundingBox(options));
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : getBoundedBySurface()) {
				if (boundarySurfaceProperty.isSetObject()) {
					boundedBy.updateEnvelope(boundarySurfaceProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink?
				}
			}
		}
		
		if (isSetGenericApplicationPropertyOfIntBridgeInstallation()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfIntBridgeInstallation()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, this, options).getEnvelope());
			}
		}

		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}

	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();
		
		lodRepresentation.addRepresentation(4, lod4Geometry);
		lodRepresentation.addRepresentation(4, lod4ImplicitRepresentation);
		
		return lodRepresentation;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IntBridgeInstallation(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntBridgeInstallation copy = (target == null) ? new IntBridgeInstallation() : (IntBridgeInstallation)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetClazz())
			copy.setClazz((Code)copyBuilder.copy(clazz));

		if (isSetFunction()) {
			for (Code part : function) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addFunction(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetUsage()) {
			for (Code part : usage) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addUsage(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetLod4Geometry()) {
			copy.setLod4Geometry((GeometryProperty<? extends AbstractGeometry>)copyBuilder.copy(lod4Geometry));
			if (copy.getLod4Geometry() == lod4Geometry)
				lod4Geometry.setParent(this);
		}
		
		if (isSetLod4ImplicitRepresentation()) {
			copy.setLod4ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod4ImplicitRepresentation));
			if (copy.getLod4ImplicitRepresentation() == lod4ImplicitRepresentation)
				lod4ImplicitRepresentation.setParent(this);
		}
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty part : boundedBySurface) {
				BoundarySurfaceProperty copyPart = (BoundarySurfaceProperty)copyBuilder.copy(part);
				copy.addBoundedBySurface(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfIntBridgeInstallation()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfIntBridgeInstallation(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
	
	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
