/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;
import org.citygml4j.model.xal.PremiseNumberPrefix;
import org.citygml4j.model.xal.XALClass;

public class PremiseNumberPrefixImpl implements PremiseNumberPrefix {
	private String value;
	private String type;
	private String numberPrefixSeparator;
	private String code;
	private ModelObject parent;
	
	public String getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	public String getNumberPrefixSeparator() {
		return numberPrefixSeparator;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public boolean isSetNumberPrefixSeparator() {
		return numberPrefixSeparator != null;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setNumberPrefixSeparator(String numberPrefixSeparator) {
		this.numberPrefixSeparator = numberPrefixSeparator;
	}

	public void unsetValue() {
		value = null;
	}

	public void unsetType() {
		type = null;
	}

	public void unsetNumberPrefixSeparator() {
		numberPrefixSeparator = null;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.PREMISE_NUMBER_PREFIX;
	}

	public String getCode() {
		return code;
	}

	public boolean isSetCode() {
		return code != null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void unsetCode() {
		code = null;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PremiseNumberPrefixImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PremiseNumberPrefix copy = (target == null) ? new PremiseNumberPrefixImpl() : (PremiseNumberPrefix)target;
		
		if (isSetValue())
			copy.setValue(copyBuilder.copy(value));
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
		if (isSetNumberPrefixSeparator())
			copy.setNumberPrefixSeparator(copyBuilder.copy(numberPrefixSeparator));
		
		if (isSetCode())
			copy.setCode(copyBuilder.copy(code));
		
		copy.unsetParent();
		
		return copy;
	}
	
	public void visit(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}