import java.util.Comparator;

/**
 * In dieser Klasse werden 2 Karten nach Wertigkeit vergleicht.
 * 
 * @author Intan
 *
 */

public class BlattVergleich implements Comparator<Blatt> {

	/**
	 * Diese Methode enthaelt die Vergleichskriterien.
	 * Die Vergleichskriterien sind wie folgt:
	 * 1. Drilling > Paar > Normal
	 * 2. Bei 2 Drillingen zaehlt das mit dem hoeheren Wert.
	 * 3. Bei 2 Paaren mit gleichem Wert zaehlt die dritte Karte.
	 * 4. Bei komplett unterschiedlichen Karten zaehlt die Summe der drei Karten.
	 * 
	 * @param card
	 * @return die Summe des Vergleichs.
	 */

	public int getCriteria(Blatt card) {

		// Drilling
		if (card.getWert1() == card.getWert2() && card.getWert1() == card.getWert3()) {
			return card.getWert1() + card.getWert2() + card.getWert3() + 100;
		// Paar
		} else if (card.getWert1() == card.getWert2()) {
			return card.getWert1() + card.getWert3() + 50;
		} else if (card.getWert1() == card.getWert3()) {
			return card.getWert1() + card.getWert2() + 50;
		} else if (card.getWert2() == card.getWert3()) {
			return card.getWert1() + card.getWert2() + 50;
		} else {

		}
		//Normal (alle Karten haben unterschiedlichen Wert)
		return card.getWert1() + card.getWert2() + card.getWert3() + 10;
	}

	/**
	 * @return die Subtraktion von Summe des Vergleichs.
	 */
	
	public int compare(Blatt b1, Blatt b2) {

		return getCriteria(b1) - getCriteria(b2);
	}
}
