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

//
// Generated with ade-xjc - XML Schema binding compiler for CityGML ADEs, version 2.6.1
// ade-xjc is part of the citygml4j project, see https://github.com/citygml4j
// Any modifications to this file will be lost upon recompilation of the source
// Generated: Sun Jan 21 21:03:34 CET 2018
//


package handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 *  Type for windows in walls. Used in LOD3 and LOD4 only . As subclass of _CityObject, a window inherits all attributes and relations, in particular an
 * 				id, names, external references, and generalization relations. 
 * 
 * <p>Java-Klasse für WindowType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WindowType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.citygml.org/ade/sub/0.9.0}AbstractOpeningType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}_GenericApplicationPropertyOfWindow" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WindowType", propOrder = {
    "_GenericApplicationPropertyOfWindow"
})
public class WindowType
    extends AbstractOpeningType
{

    protected List<Object> _GenericApplicationPropertyOfWindow;

    /**
     * Gets the value of the genericApplicationPropertyOfWindow property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfWindow property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfWindow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> get_GenericApplicationPropertyOfWindow() {
        if (_GenericApplicationPropertyOfWindow == null) {
            _GenericApplicationPropertyOfWindow = new ArrayList<Object>();
        }
        return this._GenericApplicationPropertyOfWindow;
    }

    public boolean isSet_GenericApplicationPropertyOfWindow() {
        return ((this._GenericApplicationPropertyOfWindow!= null)&&(!this._GenericApplicationPropertyOfWindow.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfWindow() {
        this._GenericApplicationPropertyOfWindow = null;
    }

}
