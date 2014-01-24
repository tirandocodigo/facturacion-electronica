package com.sng.fel.xjc;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlRootElement(name="cfdi:Comprobante")
@XmlType(name="Comprobante")
public class PurchaseOrderType {

    public USAddress Emisor;
    public USAddress billTo;
    @XmlAttribute
    public CreditCardVendor cCardVendor;
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("cfdi:Emisor ").append(Emisor).append('\n');
        s.append("cfdi:Receptor").append(billTo).append('\n');
        s.append("xmls").append(cCardVendor).append('\n');
        return s.toString();
    }
}

