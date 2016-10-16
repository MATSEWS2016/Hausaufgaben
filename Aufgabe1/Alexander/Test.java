import java.io.FileNotFoundException;

public class Test {

	public static void main(String[] args) {
		// GoldPreis gp = new GoldPreis("gold.txt");
		// System.out.println(gp.getPreis("2009-07-17"));
		// gp.printMinMax();
		try {
			GoldPreis test = new GoldPreis("gold.txt");
			// Eventuell andere Pfadangabe
			System.out.println(test.getPreis("2009-10-20")); // 22870.0
			System.out.println(test.getPreis("2009-02-07")); // -1
			test.printMinMax();
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		}
	}
}
