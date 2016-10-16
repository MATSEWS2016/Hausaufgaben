import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoldPreis {
    
    private List<GoldTagespreis> list = new ArrayList<>();
    
    public GoldPreis(String dateiname) {
        try (Scanner sc = new Scanner(new File(dateiname),"utf-8")) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                handleLine(line);
            }
        } catch (FileNotFoundException nnfe) {
            System.out.println("File not found");
        }
    }
    
    public void handleLine(String line){
        String[] lSplitted = line.split("\t");
        GoldTagespreis gt = new GoldTagespreis(lSplitted[0], lSplitted[1]);
        list.add(gt);
    }
    
    public String getPreis(String datum){
        for(GoldTagespreis gt : list){
            if(gt.getDatum().equals(datum)){
                return gt.getPreis();
            }
        }
        
        throw new NumberFormatException("Kein Preis fuer "+datum+" gefunden!");
    }
    
    public void printMinMax(){
        GoldTagespreis min = new GoldTagespreis("-", String.valueOf(Integer.MAX_VALUE));
        GoldTagespreis max = new GoldTagespreis("-", String.valueOf(0));
        
        for(GoldTagespreis g : list){
            min = min.compare(g,false);
            max = max.compare(g,true);
        }
        
        List<String> minDates= new ArrayList<>();
        List<String> maxDates = new ArrayList<>();
        
        for(GoldTagespreis g : list){
            if(g.getPreis().equals(min.getPreis())){
                minDates.add(g.getDatum());
            }
            
            if(g.getPreis().equals(max.getPreis())){
                maxDates.add(g.getDatum());
            }
        }
        
        String minPrint = "Den niedrigsten Goldpreis von "+min.getPreis()+" gab es an en folgenden Tagen:";
        printPrices(minPrint,minDates);
        String maxPrint = "Den hoechsten Goldpreis von "+max.getPreis()+" gab es an en folgenden Tagen: "+ max.getDatum();
        printPrices(maxPrint,maxDates);
    }
    
    private void printPrices(String text, List<String> days){
        System.out.println(text);
        for(String s : days){
            System.out.println(s);
        }
    }

}
