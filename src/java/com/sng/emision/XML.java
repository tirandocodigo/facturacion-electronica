/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sng.emision;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML {

    public static void main(String argv[]) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document xml = docBuilder.newDocument();
            xml.setXmlStandalone(true);
            xml.setXmlVersion("1.1");
            Element Comprobante = xml.createElement("cfdi:Comprobante");

            Attr xmlns_cfdi = xml.createAttribute("xmlns:cfdi");
            xmlns_cfdi.setValue("http://www.sat.gob.mx/cfd/3");
            Comprobante.setAttributeNode(xmlns_cfdi);

            Attr xmlns_xsi = xml.createAttribute("xmlns:xsi");
            xmlns_xsi.setValue("http://www.w3.org/2001/XMLSchema-instance");
            Comprobante.setAttributeNode(xmlns_xsi);

            Attr version = xml.createAttribute("version");
            version.setValue("3.2");
            Comprobante.setAttributeNode(version);

            Attr xsi_schemaLocation = xml.createAttribute("xsi:schemaLocation");
            xsi_schemaLocation.setValue("http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd");
            Comprobante.setAttributeNode(xsi_schemaLocation);

            Attr serie = xml.createAttribute("serie");
            serie.setValue("FM");
            Comprobante.setAttributeNode(serie);

            Attr folio = xml.createAttribute("folio");
            folio.setValue("217");
            Comprobante.setAttributeNode(folio);

            Attr fecha = xml.createAttribute("fecha");
            fecha.setValue("2014-01-03T12:33:17");
            Comprobante.setAttributeNode(fecha);

            Attr formaDePago = xml.createAttribute("formaDePago");
            formaDePago.setValue("Pago en una sola exhibicion");
            Comprobante.setAttributeNode(formaDePago);

            Attr noCertificado = xml.createAttribute("noCertificado");
            noCertificado.setValue("00001000000202284511");
            Comprobante.setAttributeNode(noCertificado);

            Attr certificado = xml.createAttribute("certificado");
            certificado.setValue("MIIEyzCCA7OgAwIBAgIUMDAwMDEwMDAwMDAyMDIyODQ1MTEwDQYJKoZIhvcNAQEFBQAwggGVMTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMSEwHwYJKoZIhvcNAQkBFhJhc2lzbmV0QHNhdC5nb2IubXgxJjAkBgNVBAkMHUF2LiBIaWRhbGdvIDc3LCBDb2wuIEd1ZXJyZXJvMQ4wDAYDVQQRDAUwNjMwMDELMAkGA1UEBhMCTVgxGTAXBgNVBAgMEERpc3RyaXRvIEZlZGVyYWwxFDASBgNVBAcMC0N1YXVodMOpbW9jMRUwEwYDVQQtEwxTQVQ5NzA3MDFOTjMxPjA8BgkqhkiG9w0BCQIML1Jlc3BvbnNhYmxlOiBDZWNpbGlhIEd1aWxsZXJtaW5hIEdhcmPDrWEgR3VlcnJhMB4XDTEyMTEwNjE5MjUzOFoXDTE2MTEwNjE5MjUzOFowggELMTkwNwYDVQQDEzBDT01FUkNJQUxJWkFET1JBIERFIENPTVBVVE8gREVMIFNVUkVTVEUgU0EgREUgQ1YxOTA3BgNVBCkTMENPTUVSQ0lBTElaQURPUkEgREUgQ09NUFVUTyBERUwgU1VSRVNURSBTQSBERSBDVjE5MDcGA1UEChMwQ09NRVJDSUFMSVpBRE9SQSBERSBDT01QVVRPIERFTCBTVVJFU1RFIFNBIERFIENWMSUwIwYDVQQtExxDQ1MwMjEwMTQ1WkEgLyBBQVNINzQwOTA5RFU5MR4wHAYDVQQFExUgLyBBQVNINzQwOTA5TVZaTE5NMDIxETAPBgNVBAsTCExBIE5PUklBMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCxHh99mt+qEuf2lu0BKvykGBF7pM9TkaFUyl+npkux9ZFvxoJY9pQwjKgGN6qHDBC97AdGFxzCAo4JiKFbUBfnkNw8d94h3ZBmP2rqUdFjMNFPOp1Mvh/B4bdIverHJAHbP7Iom7x9orehxj4CaOxEXf3BMKmkiA0CPIg0+qkjSQIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQUFAAOCAQEAR8jO6DicVwZRpfli3Xv8VMP/BWnKjR4ArIr78o4LU2Wk3K54dOvUQ95DUWr83cn9p9JkOziglw9r1SQB4tW0L7+nf1Y4+zEkyCeoGE6SqAo4Zhj9U/hOYEPHBVP+CYnhGTS02+dNRnMwYy5FlphtiSKgP2XufvyMG5b66cj3ZJ3ILVuWFk6Q18ouGAXcTFyr4WvReBJgH8r91n25fUS1FzximkeyFFHS1vx0iFUSvVxrC+8xl3v0YvPLUrDouxz3Wl1pom/4ss/TnIA8Z5d4u1Tx6ac2E6zJ+ZA14RC2ako4hRWbPqzRW9Saa2/Qsc8fYdbITgKypJxpVLJeCiix6A==");
            Comprobante.setAttributeNode(certificado);
            //Comprobante.insertBefore(xsi_schemaLocation,certificado);


            xml.appendChild(Comprobante);

            // Campos de Emisor
            Element Emisor = xml.createElement("cfdi:Emisor");
            Comprobante.appendChild(Emisor);

            // Campos de Receptor
            Element Receptor = xml.createElement("cfdi:Receptor");
            Comprobante.appendChild(Receptor);

            // Campos de Concepto
            Element Conceptos = xml.createElement("cfdi:Conceptos");
            Comprobante.appendChild(Conceptos);

            // Agregar los atributos al Emisor
            Attr rfc_Emisor = xml.createAttribute("rfc");
            rfc_Emisor.setValue("KIA101010AU7");
            Emisor.setAttributeNode(rfc_Emisor);

            Attr nombre_Emisor = xml.createAttribute("nombre");
            nombre_Emisor.setValue("GOBIERNO DEL ESTADO DE OAXACA");
            Emisor.setAttributeNode(nombre_Emisor);


            /*
             * Información del Domicilio Fiscal del Emisor
             */
            Element DomicilioFiscal = xml.createElement("cfdi:DomicilioFiscal");
            Emisor.appendChild(DomicilioFiscal);

            Attr calle = xml.createAttribute("calle");
            calle.setValue("NOMBRE DE LA CALLE");
            DomicilioFiscal.setAttributeNode(calle);

            Attr noExterior = xml.createAttribute("noExterior");
            noExterior.setValue("1001");
            DomicilioFiscal.setAttributeNode(noExterior);

            Attr colonia = xml.createAttribute("colonia");
            colonia.setValue("NOMBRE DE LA COLONIA");
            DomicilioFiscal.setAttributeNode(colonia);

            Attr municipio = xml.createAttribute("municipio");
            municipio.setValue("NOMBRE DEL MUNICIPIO");
            DomicilioFiscal.setAttributeNode(municipio);

            Attr estado = xml.createAttribute("estado");
            estado.setValue("OAXACA DE JUAREZ");
            DomicilioFiscal.setAttributeNode(estado);

            Attr pais = xml.createAttribute("pais");
            pais.setValue("MEXICO");
            DomicilioFiscal.setAttributeNode(pais);

            Attr codigoPostal = xml.createAttribute("codigoPostal");
            codigoPostal.setValue("68000");
            DomicilioFiscal.setAttributeNode(codigoPostal);
            /*
             * Fin DomicilioFiscal
             */


            /*
             * ExpedidoEn
             */
            Element ExpedidoEn = xml.createElement("cfdi:ExpedidoEn");
            Emisor.appendChild(ExpedidoEn);

            Attr calle_Expedido = xml.createAttribute("calle");
            calle_Expedido.setValue("NOMBRE DE LA CALLE");
            ExpedidoEn.setAttributeNode(calle_Expedido);

            Attr noExterior_Expedido = xml.createAttribute("noExterior");
            noExterior_Expedido.setValue("1001");
            ExpedidoEn.setAttributeNode(noExterior_Expedido);

            Attr colonia_Expedido = xml.createAttribute("colonia");
            colonia_Expedido.setValue("NOMBRE DE LA COLONIA");
            ExpedidoEn.setAttributeNode(colonia_Expedido);

            Attr municipio_Expedido = xml.createAttribute("municipio");
            municipio_Expedido.setValue("NOMBRE DEL MUNICIPIO");
            ExpedidoEn.setAttributeNode(municipio_Expedido);

            Attr estado_Expedido = xml.createAttribute("estado");
            estado_Expedido.setValue("OAXACA DE JUAREZ");
            ExpedidoEn.setAttributeNode(estado_Expedido);

            Attr pais_Expedido = xml.createAttribute("pais");
            pais_Expedido.setValue("MEXICO");
            ExpedidoEn.setAttributeNode(pais_Expedido);

            Attr codigoPostal_Expedido = xml.createAttribute("codigoPostal");
            codigoPostal_Expedido.setValue("68000");
            ExpedidoEn.setAttributeNode(codigoPostal_Expedido);


            /*
             * RegimenFiscal
             */
            Element RegimenFiscal = xml.createElement("cfdi:RegimenFiscal");
            Emisor.appendChild(RegimenFiscal);

            Attr Regimen = xml.createAttribute("Regimen");
            Regimen.setValue("REGIMEN GENERAL DE LEY PERSONAS MORALES");
            RegimenFiscal.setAttributeNode(Regimen);

            /*
             * Agregamos Atributos del Nodo <cfdi:Receptor>
             */
            Attr rfc_Receptor = xml.createAttribute("rfc");
            rfc_Receptor.setValue("SACJ89062968A");
            Receptor.setAttributeNode(rfc_Receptor);

            Attr nombre_Receptor = xml.createAttribute("nombre");
            nombre_Receptor.setValue("Nombre del Contribuyente");
            Receptor.setAttributeNode(nombre_Receptor);


            // Campos de Domicilio del Receptor
            Element DomicilioReceptor = xml.createElement("cfdi:Domicilio");
            Receptor.appendChild(DomicilioReceptor);

            //Calle del Receptor
            Attr calle_Receptor = xml.createAttribute("calle");
            calle_Receptor.setValue("CALLE DEL RECEPTOR");
            DomicilioReceptor.setAttributeNode(calle_Receptor);

            //Colonia del Receptor
            Attr colonia_Receptor = xml.createAttribute("colonia");
            colonia_Receptor.setValue("CALLE DEL RECEPTOR");
            DomicilioReceptor.setAttributeNode(colonia_Receptor);

            Attr localidad_Receptor = xml.createAttribute("localidad");
            localidad_Receptor.setValue("CALLE DEL RECEPTOR");
            DomicilioReceptor.setAttributeNode(localidad_Receptor);

            Attr estado_Receptor = xml.createAttribute("estado");
            estado_Receptor.setValue("ESTADO DEL CONTRIBUYENTE");
            DomicilioReceptor.setAttributeNode(estado_Receptor);

            Attr pais_Receptor = xml.createAttribute("pais");
            pais_Receptor.setValue("MEXICO");
            DomicilioReceptor.setAttributeNode(pais_Receptor);

            Attr codigoPostal_Receptor = xml.createAttribute("codigoPostal");
            codigoPostal_Receptor.setValue("71230");
            DomicilioReceptor.setAttributeNode(codigoPostal_Receptor);


            // Campos de Concepto de Conceptos
            
            
            
            for (int i = 0; i < 10; i++) {
                // Campos de Concepto de Conceptos
                Element Concepto = xml.createElement("cfdi:Concepto");
                Conceptos.appendChild(Concepto);
                
                Attr cantidad = xml.createAttribute("cantidad");
                cantidad.setValue("" + i);
                Concepto.setAttributeNode(cantidad);

                Attr unidad = xml.createAttribute("unidad");
                unidad.setValue("PIEZA");
                Concepto.setAttributeNode(unidad);

                Attr noIdentificacion = xml.createAttribute("noIdentificacion");
                noIdentificacion.setValue("WVWTG71K6DP051601");
                Concepto.setAttributeNode(noIdentificacion);

                Attr descripcion = xml.createAttribute("descripcion");
                descripcion.setValue("CONCEPTO DEL COBRO");
                Concepto.setAttributeNode(descripcion);

                Attr valorUnitario = xml.createAttribute("valorUnitario");
                valorUnitario.setValue("238");
                Concepto.setAttributeNode(valorUnitario);

            }



            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //DOMSource source = new DOMSource(Comprobante);


            // write the content into xml file
            DOMSource source = new DOMSource(xml);


            StreamResult file = new StreamResult(new File("/home/jesus/SAT/xml_linux.xml"));
            //StreamResult result = new StreamResult(new File("C:\\SAT\\xml_win2.xml"));
            StreamResult console = new StreamResult(System.out);
            //StreamResult file = new StreamResult(new File("C:\\SAT\\_FacturaElectronica.xml"));
            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("Terminé!");
            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            //transformer.transform(source, result);

            //System.out.println("Hecho!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}