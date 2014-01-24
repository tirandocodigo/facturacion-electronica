package com.sng.fel.web;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Ejemplo {

    public static void main(String[] args) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement =doc.createElement("cfdi:Comprobante");
            doc.appendChild(rootElement);
            
            rootElement.appendChild(getEmisor(doc, "SACJ89062968A", "Jesus"));

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.VERSION, "3.2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("/SAT/FacturaElectronica.xml"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("Terminé!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node getEmisor(Document doc, String id, String name) {
        Element emisor = doc.createElement("cfdi:Emisor");  
        emisor.setAttribute("nombre",name);
        emisor.setAttribute("rfc",id);        
        emisor.appendChild(getEmployeeElements(doc, emisor, "cfdi:ExpedidoEn", name));
        return emisor;
    }

    private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}