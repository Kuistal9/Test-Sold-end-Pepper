import org.w3c.dom.*;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
public class redactor  {
    public static void red()  {
        Scanner scanner = new Scanner ( System.in );
        System.out.println ("Выбирите пункт который хотите изминить " );

        Object Teg = scanner.next ();
        System.out.println ("В видите новый текст без пробелов " );
        Object text = scanner.next ();
        String filePath = "src/task.xml";
        File xmlFile = new File ( filePath );

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance ();
        DocumentBuilder builder;

        /**
         *  создание метода для обработки XML документа
         *  xmlFile = src/task.xml
         */
        try {
            builder = factory.newDocumentBuilder ();
            Document doc = builder.parse ( xmlFile );
            doc.getDocumentElement ().normalize ();
            addElement ( doc , Teg, text );
            doc.getDocumentElement ().normalize ();
            TransformerFactory transformerFactory = TransformerFactory.newInstance ();
            Transformer transformer = transformerFactory.newTransformer ();
            DOMSource source = new DOMSource ( doc );
            StreamResult result = new StreamResult ( new File ( "src/task.xml" ) );
            transformer.setOutputProperty ( OutputKeys.INDENT , "yes" );
            transformer.transform ( source , result );
            System.out.println ( "XML успешно изменен!" );

            } catch (Exception exc) {
            exc.printStackTrace ();
        }
    }
    public static void addElement(Document doc , Object Teg, Object text) {
/**
 *  проходимся по всем тегам и записываем новое описание
 *  Teg - тег который мы выбираем
 *  text - текст который мы вписываем
 */
        NodeList languages = doc.getElementsByTagName ( String.valueOf ( Teg ) );
        Element lang = null;

        for (int i = 0 ; i < languages.getLength () ; i++) {

            lang = (Element) languages.item ( i );
            Text paradigmElement = doc.createTextNode ( String.valueOf ( text ) );
            lang.appendChild ( paradigmElement );
            return;
        }
    }
}