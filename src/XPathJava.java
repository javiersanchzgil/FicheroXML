
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathJava {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

        File f = new File ("FichEmpleado1.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document docL = db.parse(f);

        XPathFactory xPF = XPathFactory.newInstance();
        XPath xP = xPF.newXPath();

        XPathExpression xExp = xP.compile("//Emleados/Empleado/apellidos[@orden='primero']/apellido1");
        NodeList nl = (NodeList) xExp.evaluate(docL, XPathConstants.NODESET);


        for (int i = 0; i < nl.getLength(); i++) {
            System.out.println(nl.item(i).getTextContent());
        }


       /* NodeList nodos = (NodeList) obj;

        for (int i = 0;i<nodos.getLength();i++) {
            System.out.println(nodos.item(i).getNodeValue());
        }*/

    }

}
