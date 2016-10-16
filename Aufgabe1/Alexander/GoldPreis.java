import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * GoldPreis füllt, anhand einer utf-8 codierten .txt Datei, eine ArrayList mit
 * {@link GoldTagespreis} Objekten. Außerdem enthält die Klasse einige
 * Funktionen um beispielsweiße den Preis an einem bestimmten Tag, oder den
 * Minimalen und Maximalen Preis auszugeben.
 * 
 * @author Alexander Brennecke
 *
 */
public class GoldPreis {

	// / ATTRIBUTE///
	private List<GoldTagespreis> list = new ArrayList<>();

	// /KONSTRUKTOREN///
	public GoldPreis(String dateiname) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(dateiname), "utf-8");
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			handleLine(line);
		}
		sc.close();
	}

	// /METHODEN///
	/**
	 * Gibt den Preis am angegebenen Datum zurück, oder eine Meldung, falls kein
	 * Preis vorhanden ist.
	 * 
	 * @param datum
	 *            in der Form yyyy-mm-tt
	 * @throws NumberFormatException
	 *             , wenn es keinen Preis an dem Datum gibt.
	 * @return den Preis des angegebenen Datums
	 */
	public double getPreis(String datum) throws NumberFormatException {
		for (GoldTagespreis gt : list) {
			if (gt.getDatum().equals(datum)) {
				return gt.getPreis();
			}
		}
		throw new NumberFormatException("Kein Preis fuer " + datum + " gefunden!");
	}

	/**
	 * Gibt die Tage mit dem höchsten und dem niedrigsten Preis in der Konsole
	 * aus.
	 */
	public void printMinMax() {
		// Definiert zwei neue Preise mit dem höchsten und dem niedrigsten Wert
		GoldTagespreis min = new GoldTagespreis("-", String.valueOf(Integer.MAX_VALUE));
		GoldTagespreis max = new GoldTagespreis("-", String.valueOf(0));

		// Iteration durch alle Preise um den niedrigsten und den höchsten Preis
		// zu finden
		for (GoldTagespreis g : list) {
			// überprüfen ob g kleiner ist
			min = min.compare(g, false);
			// überprüfen ob g größer ist
			max = max.compare(g, true);
		}

		// Eine Liste für alle Tage mit dem höchsten und eine für alle mit dem
		// niedrigsten Preis
		List<String> minDates = new ArrayList<>();
		List<String> maxDates = new ArrayList<>();

		// Erneute Iteration um alle Daten mit dem höchsten/niedrigsten Preis zu
		// finden
		for (GoldTagespreis g : list) {
			if (g.getPreis() == min.getPreis()) {
				minDates.add(g.getDatum());
			}

			if (g.getPreis() == max.getPreis()) {
				maxDates.add(g.getDatum());
			}
		}

		//Ausgabe mit Hilfe der printPricesAndDays Methode
		String minPrint = "Den niedrigsten Goldpreis von " + min.getPreis() + " gab es an en folgenden Tagen:";
		printPricesAndDays(minPrint, minDates);
		String maxPrint = "Den hoechsten Goldpreis von " + max.getPreis() + " gab es an en folgenden Tagen: " + max.getDatum();
		printPricesAndDays(maxPrint, maxDates);
	}

	/**
	 * Gibt den Text und alle Elemente der Liste untereinander aus.
	 * @param text wird in der Konsole ausgegeben
	 * @param days jedes Element wird untereinander in der Konsole ausgegeben
	 */
	private void printPricesAndDays(String text, List<String> days) {
		System.out.println(text);
		for (String s : days) {
			System.out.println(s);
		}
	}

	/**
	 * Erzeugt aus einem String ein {@link GoldTagespreis} Objekt und fügt es der Liste aller Preise hinzu.
	 * @param line eine Zeile aus der Eingabe Datei.
	 */
	private void handleLine(String line) {
		String[] lSplitted = line.split("\t");
		GoldTagespreis gt = new GoldTagespreis(lSplitted[0], lSplitted[1]);
		list.add(gt);
	}

}
