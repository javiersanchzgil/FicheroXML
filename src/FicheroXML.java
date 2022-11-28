import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class FicheroXML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        File f = new File("FichEmpleados.xml");

        org.w3c.dom.Element raiz;
        org.w3c.dom.Element elem;
        org.w3c.dom.Element elemSub;
        Text text;
        Attr attr;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        DOMImplementation imp = db.getDOMImplementation();

        // Creamos la etiqueta raíz del XML (en este caso, "Empleados")
        Document doc = imp.createDocument(null, "Empleados", null);
        doc.setXmlVersion("1.0");

        // Creamos la etiqueta "Empleado" y la añadimos a la raíz
        raiz = doc.createElement("Empleado");
        doc.getDocumentElement().appendChild(raiz);

        // Creamos la etiqueta "id" con valor "1" y la añadimos a la etiqueta "Empleado"
        elem = doc.createElement("id");
        text = doc.createTextNode("1");
        raiz.appendChild(elem);
        elem.appendChild(text);

        // Creamos la etiqueta "apellidos" y lo añadimos a la etiqueta "Empleado"
        elem = doc.createElement("apellidos");
        raiz.appendChild(elem);
        attr = doc.createAttribute("orden");
        attr.setValue("primero");
        elem.setAttributeNode(attr);

        // Creamos la etiqueta "apellido1" con valor "Pérez" y la añadimos a la etiqueta "apellidos"
        elemSub = doc.createElement("apellido1");
        text = doc.createTextNode("Pérez");
        elem.appendChild(elemSub);
        elemSub.appendChild(text);

        // Creamos la etiqueta "apellido2" con valor "Sánz" y la añadimos a la etiqueta "apellidos"
        elemSub = doc.createElement("apellido2");
        text = doc.createTextNode("Sánz");
        elem.appendChild(elemSub);
        elemSub.appendChild(text);

        // Creamos la etiqueta "dep" con valor "150" y la añadimos a la etiqueta "Empleado"
        elem = doc.createElement("dep");
        text = doc.createTextNode("150");
        raiz.appendChild(elem);
        elem.appendChild(text);

        // EMPLEADO NÚMERO 2

        // Creamos la etiqueta "Empleado" y la añadimos a la raíz
        raiz = doc.createElement("Empleado");
        doc.getDocumentElement().appendChild(raiz);

        // Creamos la etiqueta "id" con valor "1" y la añadimos a la etiqueta "Empleado"
        elem = doc.createElement("id");
        text = doc.createTextNode("2");
        raiz.appendChild(elem);
        elem.appendChild(text);

        // Creamos la etiqueta "apellidos" y lo añadimos a la etiqueta "Empleado"
        elem = doc.createElement("apellidos");
        raiz.appendChild(elem);
        attr = doc.createAttribute("orden");
        attr.setValue("primero");
        elem.setAttributeNode(attr);

        // Creamos la etiqueta "apellido1" con valor "Pérez" y la añadimos a la etiqueta "apellidos"
        elemSub = doc.createElement("apellido1");
        text = doc.createTextNode("González");
        elem.appendChild(elemSub);
        elemSub.appendChild(text);

        // Creamos la etiqueta "apellido2" con valor "Sánz" y la añadimos a la etiqueta "apellidos"
        elemSub = doc.createElement("apellido2");
        text = doc.createTextNode("Ruíz");
        elem.appendChild(elemSub);
        elemSub.appendChild(text);

        // Creamos la etiqueta "dep" con valor "150" y la añadimos a la etiqueta "Empleado"
        elem = doc.createElement("dep");
        text = doc.createTextNode("150");
        raiz.appendChild(elem);
        elem.appendChild(text);

        // FIN EMPLEADO NÚMERO 2

        Source source = new DOMSource(doc);
        Result result = new StreamResult(f);
        Transformer transf = TransformerFactory.newInstance().newTransformer();
        transf.transform(source, result);

        System.out.println("Fichero XML creado correctamente");

        leerFicheroXML(f);

    }

    public static void leerFicheroXML(File f) throws ParserConfigurationException, IOException, SAXException {
        Element element = null;

        DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
        DocumentBuilder dB = dBF.newDocumentBuilder();

        Document docL = dB.parse(f);
        NodeList empleados = docL.getElementsByTagName("Empleado");
        System.out.println(empleados.getLength());

        for(int i = 0; i < empleados.getLength(); i++) {
            Node emp = empleados.item(i);
            element = (Element) emp;

            System.out.println(element.getElementsByTagName("id").item(i).getTextContent());
            System.out.println(element.getElementsByTagName("apellido1").item(i).getTextContent());
            Element elemAt = (Element) element.getElementsByTagName("apellidos").item(0);
            System.out.println(elemAt.getAttribute("orden"));
        }

    }
}