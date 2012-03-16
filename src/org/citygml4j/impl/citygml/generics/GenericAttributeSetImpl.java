package org.citygml4j.impl.citygml.generics;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;
import org.citygml4j.model.citygml.generics.GenericAttributeSet;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.module.citygml.GenericsModule;

public class GenericAttributeSetImpl extends AbstractGenericAttributeImpl implements GenericAttributeSet {
	private List<AbstractGenericAttribute> genericAttribute;
	private String codeSpace;
	
	public GenericAttributeSetImpl() {
		
	}
	
	public GenericAttributeSetImpl(GenericsModule module) {
		super(module);
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GENERIC_ATTRIBUTE_SET;
	}

	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public void addGenericAttribute(AbstractGenericAttribute genericAttribute) {
		if (this.genericAttribute == null)
			this.genericAttribute = new ChildList<AbstractGenericAttribute>(this);
		
		this.genericAttribute.add(genericAttribute);
	}
	
	public List<AbstractGenericAttribute> getGenericAttribute() {
		if (genericAttribute == null)
			genericAttribute = new ChildList<AbstractGenericAttribute>(this);
		
		return genericAttribute;
	}

	public String getCodeSpace() {
		return codeSpace;
	}

	public boolean isSetGenericAttribute() {
		return genericAttribute != null && !genericAttribute.isEmpty();
	}

	public boolean isSetCodeSpace() {
		return genericAttribute != null;
	}

	public void setGenericAttribute(List<AbstractGenericAttribute> genericAttribute) {
		this.genericAttribute = new ChildList<AbstractGenericAttribute>(this, genericAttribute);
	}

	public void setCodeSpace(String codeSpace) {
		this.codeSpace = codeSpace;
	}

	public void unsetGenericAttribute() {
		if (isSetGenericAttribute())
			genericAttribute.clear();
		
		genericAttribute = null;
	}

	public boolean unsetGenericAttribute(AbstractGenericAttribute genericAttribute) {
		return isSetGenericAttribute() ? this.genericAttribute.remove(genericAttribute) : false;
	}

	public void unsetCodeSpace() {
		codeSpace = null;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GenericAttributeSetImpl(), copyBuilder);
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GenericAttributeSet copy = (target == null) ? new GenericAttributeSetImpl() : (GenericAttributeSet)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetCodeSpace())
			copy.setCodeSpace(copyBuilder.copy(codeSpace));
		
		if (isSetGenericAttribute()) {
			for (AbstractGenericAttribute part : genericAttribute) {
				AbstractGenericAttribute copyPart = (AbstractGenericAttribute)copyBuilder.copy(part);
				copy.addGenericAttribute(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}

}
