//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.02.03 um 11:14:53 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * A discrete coverage type whose domain is defined by a collection of point
 * 
 * <p>Java-Klasse für MultiPointCoverageType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MultiPointCoverageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.opengis.net/gml}AbstractDiscreteCoverageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://www.opengis.net/gml}StandardObjectProperties"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}boundedBy" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}multiPointDomain"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}rangeSet"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}coverageFunction" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiPointCoverageType")
public class MultiPointCoverageType
    extends AbstractDiscreteCoverageType
{


}
