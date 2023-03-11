import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Scanner;

public class menu {
    public static void menu () throws IOException, SAXException, ParserConfigurationException, XPathExpressionException, XMLStreamException {

        System.out.println ("Меню. В видите номер пункта который вас интересует" );
        System.out.println ("1.Вывод" );
        System.out.println ("2.редактор" );
        System.out.println ("3.выход");
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("Нужно положительное число!");
            while (!sc.hasNextInt()) {
                System.out.println("Ввидино не число");
                sc.next();
            }
            number = sc.nextInt();
        } while (number <= 0);

       switch (number) {
           case 1:   System.out.println ("Вывод");
               conclusion.start ();
               System.out.println ("какой пункт вас интересует");
               conclusion_choice.search_element () ;
           case 2: System.out.println ( "редактор" );
               redactor.red ();
           case 3:System.out.println ( "выход" );
               return;

       }
    }

}