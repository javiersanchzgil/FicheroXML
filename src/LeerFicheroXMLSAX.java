
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;

@SuppressWarnings("deprecation")
public class LeerFicheroXMLSAX {

    public static void main(String[] args) throws SAXException, IOException {

        XMLReader pXML = XMLReaderFactory.createXMLReader();
        MiDefaultHandler mDF = new MiDefaultHandler();
        pXML.setContentHandler(mDF);
        InputSource fichXML = new InputSource("FichEmpleado1.xml");
        pXML.parse(fichXML);
    }

}

class MiDefaultHandler extends DefaultHandler {

    MiDefaultHandler() {
        super();
    }

    public void startDocument() {
        System.out.println("Comienzo SAX");
    }

    public void endDocument() {
        System.out.println("Final SAX");
    }

    public void startElement(String uri, String nombre, String nombreC, org.xml.sax.Attributes atts) {
        System.out.println("Comienzo elemento: " + nombre);
    }

    public void endElement(String uri, String nombre, String nombreC) {
        System.out.println("Fin elemento: " + nombre);
    }

    public void characters(char[] ch, int inicio, int longitud) {
        String car = new String(ch, inicio, longitud);
        System.out.println(car);
    }
}
