/**
 * Die Klasse Blatt representiert ein Blatt aus drei Karten beim Pokerspiel.
 * 
 * @author Intan
 *
 */
public class Blatt {
	private int[] card = new int[3];

	/**
	 * Im Konstruktor wird card initialisiert.
	 * @param card
	 * @throws ArithmeticException
	 *             falls die Laenge der Karte nicht 3 ist und ihrer Wert nicht
	 *             zwischen 2 und 14 liegt.
	 */
	public Blatt(int[] card) {
		if (this.card.length != card.length) {
			throw new ArithmeticException("Ihre Karte müssen insgesamt 3 sein.");
		}
		for (int i = 0; i < 3; i++) {
			if (card[i] > 1 && card[i] < 15) {
				this.card = card.clone();
			} else {
				throw new ArithmeticException("Der Wert muss zwischen 2 und 14 liegen.");
			}
		}

	}
	public int getWert1() {
		return this.card[0];
	}

	public int getWert2() {
		return this.card[1];
	}

	public int getWert3() {
		return this.card[2];
	}

	/**
	 * Diese Methode gibt die Werte der Karte zurueck.
	 */

	public String toString() {
		String s = "";

		return s + getWert1() + ", " + getWert2() + ", " + getWert3();
	}

}


