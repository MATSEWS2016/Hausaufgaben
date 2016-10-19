import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EMailAddressBuch {
    
    private Map<String, String> buch;
    
    public EMailAddressBuch(){
        buch = new HashMap<>();
    }
    
    public void einlesen(String dateiname){
        try(Scanner sc = new Scanner(new File(dateiname))){
           read(sc);
        }catch(FileNotFoundException nfee){
            nfee.printStackTrace();
        }
    }
    
    private void read(Scanner sc){
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] splittedLine = line.split(";");
            einfuegen(splittedLine[0], splittedLine[1]);
        }
    }
    
    public void einfuegen(String name, String email){
        buch.put(name, email);
    }
    
    public String abfrage(String name){
        if(buch.containsKey(name)){
            return buch.get(name);
        }else{
            throw new UnknownNameException("Name nicht vorhanden!");
        }
    }
    
    public void mitarbeiterEinlesen(URL url) throws IOException{
        URLConnection con = url.openConnection();
        Object content = con.getContent();
        Scanner sc = new Scanner((InputStream)content);
        read(sc);
        sc.close();
    }
    
    public String toString(){
       return buch.toString();
    }

}
