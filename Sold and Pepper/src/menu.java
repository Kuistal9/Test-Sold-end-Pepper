import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Scanner;
public class menu {
    public static void menu () throws IOException, SAXException, ParserConfigurationException, XPathExpressionException, XMLStreamException {
        int a = 0;
        System.out.println ("Меню. В видите номер пункта который вас интересует" );
        System.out.println ("1.Вывод" );
        System.out.println ("2.редактор" );
        System.out.println ("3.cписок команд" );
        System.out.println ("4.выход");
        Scanner scanner = new Scanner ( System.in );
        a = scanner.nextInt ();
        if (a == 1 ){
            System.out.println ("Вывод");
            test.start ();
            test2.main() ;
        }
        else if (a == 2){
            System.out.println ( " Выбирите действие  " );
            System.out.println ( " 1.редактор   " );
            System.out.println ( " 2.создать новый Task   " );
            int b =0;
            b = scanner.nextInt ();
            if (b==1) {
                System.out.println ( "редактор" );
                redactor.red ();
            }
            else {
                create_new_task.new_task ();

            }
        }
        else if (a == 3){
            System.out.println ("cписок команд ");
        }
        else if (a == 4) {
            System.out.println ( "выход" );
            return;
        }
        else {
            System.out.println ( "Данного пункта нет в списке" );
            menu ();
        }
    }

}