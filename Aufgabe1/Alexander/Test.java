
public class Test {
    
    public static void main(String[] args){
        GoldPreis gp = new GoldPreis("gold.txt");
        System.out.println(gp.getPreis("2009-07-17"));
        gp.printMinMax();
    }

}
