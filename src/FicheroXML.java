import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
public class FicheroXML{
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {


        File f= new File("fichEmpleado1.xml");
        Element raiz, elem, elemSub, elemAttr;
        Text text;
        Attr attr;
        DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
        DocumentBuilder dB = dBF.newDocumentBuilder();
        DOMImplementation imp = dB.getDOMImplementation();
        Document doc = imp.createDocument(null,"Empleados",null);
        doc.setXmlVersion("1.0");
        raiz = doc.createElement("Empleado");
        doc.getDocumentElement().appendChild(raiz);
        elem = doc.createElement("id");
        text = doc.createTextNode("1");
        raiz.appendChild(elem);
        elem.appendChild(text);
        elem=doc.createElement("apellidos");
        raiz.appendChild(elem);
        attr=doc.createAttribute("orden");
        attr.setValue("primero");
        elem.setAttributeNode(attr);
        elemSub=doc.createElement("apellido1");
        text=doc.createTextNode("Pérez");
        elem.appendChild(elemSub);
        elemSub=doc.createElement("apellido2");
        text=doc.createTextNode("Sanz");
        elem.appendChild(elemSub);
        elemSub.appendChild(text);
        elem = doc.createElement("departamento");
        text = doc.createTextNode("150");
        raiz.appendChild(elem);
        elem.appendChild(text);
        Source source = new DOMSource(doc);
        Result result = new StreamResult(f);
        Transformer transf = TransformerFactory.newInstance().newTransformer();
        transf.transform(source, result);
        System.out.println("Fichero XML creado correctamente");
    }
}