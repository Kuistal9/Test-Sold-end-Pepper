
import javax.xml.stream.*;
import java.io.*;

public class test {

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
                // else if (xmlReader.hasText () && xmlReader.getText ().trim ().length () > 0) {
                //  System.out.println ( " " + xmlReader.getText () );
                //}
            }
        }
        catch (FileNotFoundException |  XMLStreamException ex  ) {
            ex.printStackTrace();  }
    }

  }

