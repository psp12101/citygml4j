//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.11.28 um 11:40:21 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class TopologyStyleRef
    extends JAXBElement<TopologyStylePropertyType>
{

    protected final static QName NAME = new QName("http://www.opengis.net/gml", "topologyStyle");

    public TopologyStyleRef(TopologyStylePropertyType value) {
        super(NAME, ((Class) TopologyStylePropertyType.class), null, value);
    }

    public TopologyStyleRef() {
        super(NAME, ((Class) TopologyStylePropertyType.class), null, null);
    }

}
