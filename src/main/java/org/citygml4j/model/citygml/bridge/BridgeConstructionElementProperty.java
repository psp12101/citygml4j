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
import org.citygml4j.model.gml.feature.FeatureProperty;

public class BridgeConstructionElementProperty extends FeatureProperty<BridgeConstructionElement> implements BridgeModuleComponent {

	public BridgeConstructionElementProperty() {
		
	}
	
	public BridgeConstructionElementProperty(BridgeConstructionElement bridgeConstructionElement) {
		super(bridgeConstructionElement);
	}
	
	public BridgeConstructionElementProperty(String href) {
		super(href);
	}
	
	public BridgeConstructionElement getBridgeConstructionElement() {
		return super.getObject();
	}

	public boolean isSetBridgeConstructionElement() {
		return super.isSetObject();
	}

	public void setBridgeConstructionElement(BridgeConstructionElement bridgeConstructionElement) {
		super.setObject(bridgeConstructionElement);
	}

	public void unsetBridgeConstructionElement() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BRIDGE_CONSTRUCTION_ELEMENT_PROPERTY;
	}

	@Override
	public Class<BridgeConstructionElement> getAssociableClass() {
		return BridgeConstructionElement.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BridgeConstructionElementProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BridgeConstructionElementProperty copy = (target == null) ? new BridgeConstructionElementProperty() : (BridgeConstructionElementProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
