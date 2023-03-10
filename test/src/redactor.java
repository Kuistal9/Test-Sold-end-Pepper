import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import  java.util.Scanner;
import javax.sql.rowset.spi.XmlWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class redactor {
        public static void red() throws FileNotFoundException, XMLStreamException, XPathExpressionException {
            Scanner scanner = new Scanner ( System.in );
            Object Teg = new Object ();
            Teg = scanner;
            String filePath = "src/task.xml";
            File xmlFile = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            try {
                builder = factory.newDocumentBuilder();
                Document doc = builder.parse(xmlFile);
                doc.getDocumentElement().normalize();

                // обновляем значения
                updateElementValue(doc,Teg);

                // добавляем новый элемент
                addElement(doc,Teg);

                // запишем отредактированный элемент в файл
                // или выведем в консоль
                doc.getDocumentElement().normalize();
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource (doc);
                StreamResult result = new StreamResult (new File("src/task.xml"));
                transformer.setOutputProperty( OutputKeys.INDENT, "yes");
                transformer.transform(source, result);
                System.out.println("XML успешно изменен!");

            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }

    // добавили элемент paradigm
    public static void addElement(Document doc,Object Teg) {

        NodeList languages = doc.getElementsByTagName(String.valueOf ( Teg ));
        Element lang = null;

        //проходим по каждому элементу Language
        for(int i=0; i<languages.getLength(); i++){
            lang = (Element) languages.item(i);
            Element paradigmElement = doc.createElement( String.valueOf ( Teg ) );
            paradigmElement.appendChild(doc.createTextNode("oop"));
            lang.appendChild(paradigmElement);
        }
    }

    // изменяем значение существующего элемента name
     static void updateElementValue(Document doc,Object Teg ) {
        NodeList languages = doc.getElementsByTagName(String.valueOf ( Teg ));
        Element lang = null;
        // проходим по каждому элементу Language
        for(int i=0; i<languages.getLength();i++){
            lang = (Element) languages.item(i);
            Node name = lang.getElementsByTagName("name").item(0).getFirstChild();
            name.setNodeValue(name.getNodeValue().toUpperCase());
        }


        }
}














