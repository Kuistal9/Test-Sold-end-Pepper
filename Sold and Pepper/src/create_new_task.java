/**
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class create_new_task {
    public static   void new_task() throws FileNotFoundException, XMLStreamException {
        final String fileName = "src/task.xml";
        XMLOutputFactory factory = XMLOutputFactory.newFactory() ;
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream ( fileName) );
        writer.writeStartElement(  "root");
        writer.writeStartElement(  "font");
        writer.writeEndElement();
        writer.writeEndElement();

    }
}

*/