
import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class test2 extends test   {

    static void main() throws ParserConfigurationException, SAXException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("src/task.xml"));

        String element = reader.readLine();

        NodeList matchedElementsList = document.getElementsByTagName(element);

        if (matchedElementsList.getLength() == 0) {
            System.out.println("Тег " + element + " не был найден в файле.");
        } else {
            Node foundedElement = matchedElementsList.item(0);

            System.out.println("Элемент был найден!");

            if (foundedElement.hasChildNodes())
                ChildNodes (foundedElement.getChildNodes());
        }
    }
    private static void ChildNodes(NodeList list) {
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);

            if (node.getNodeType() == Node.TEXT_NODE) {
                String textInformation = node.getNodeValue().replace("\n", "").trim();

                if(!textInformation.isEmpty())
                    System.out.println("Внутри элемента найден текст: " + node.getNodeValue());
            }
            else {
                System.out.println("Найден элемент: " + node.getNodeName() + ", его атрибуты:");

                NamedNodeMap attributes = node.getAttributes();

                for (int k = 0; k < attributes.getLength(); k++)
                    System.out.println("Имя атрибута: " + attributes.item(k).getNodeName() + ", его значение: " + attributes.item(k).getNodeValue());
            }
            if (node.hasChildNodes())
                ChildNodes (node.getChildNodes());

        }
    }
}
