//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.building._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AssociationType;


/**
 * Denotes the relation of an _AbstractBuilding to its building parts. The BuildingPartPropertyType element
 * 				must either carry a reference to a BuildingPart object or contain a BuildingPart object inline, but neither both nor
 * 				none.
 * 
 * <p>Java-Klasse für BuildingPartPropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BuildingPartPropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.opengis.net/gml}AssociationType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/building/1.0}BuildingPart"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuildingPartPropertyType")
public class BuildingPartPropertyType
    extends AssociationType
{


}
