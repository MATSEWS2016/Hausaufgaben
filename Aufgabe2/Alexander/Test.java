import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {

    public static void main(String[] args) {
        EMailAddressBuch buch = new EMailAddressBuch();
        buch.einlesen("emailadressbuch.txt");

        URL intern, extern;
        try {
            intern = new URL("https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_intern.txt");
            buch.mitarbeiterEinlesen(intern);
            extern = new URL("https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_extern.txt");
            buch.mitarbeiterEinlesen(extern);
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL format");
        } catch (IOException e) {
            System.out.println("Invalid URL");
        }
        
        System.out.println(buch);

    }
}
