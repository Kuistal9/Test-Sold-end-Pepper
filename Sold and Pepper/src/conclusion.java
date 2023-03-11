import javax.xml.stream.*;
import java.io.*;
public class conclusion {
    public static void start () {
        final String fileName = "src/task.xml";
        try {
            XMLStreamReader xmlReader = XMLInputFactory.newInstance().
                    createXMLStreamReader(fileName, new FileInputStream (fileName)) ;
            while (xmlReader.hasNext()) {
                xmlReader.next ();
                if (xmlReader.isStartElement ()) {
                    System.out.println ( xmlReader.getLocalName () );
                }
            }
        }
        catch (FileNotFoundException |  XMLStreamException ex  ) {
            ex.printStackTrace();  }
    }

}

