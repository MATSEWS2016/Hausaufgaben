import java.util.ArrayList;

/**
 * Die Klasse enthaelt im sogenannten "Schiebepuzzle", in dem 15 Plaettchen in
 * einem 4x4 grossen Rahmen angeordnet sind. Durch horizontales und vertikales
 * Verschieben koennen die Plaettchen gemischt werden. Das Puzzle besteht darin,
 * anschliessend die oben abgebildete Reihenfolge wiederherzustellen.
 * 
 * @author Intan
 *
 */
public class Schiebepuzzle {

	private int[][] feld;

	/**
	 * Im Konstruktor wird feld initialisiert.
	 */

	public Schiebepuzzle() {
		int[][] array = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 0 } };
		this.feld = array.clone();

	}

	/**
	 * Diese Methode ueberprueft ob das Plaettchen Nummer i verschiebbar ist bzw
	 * ob das Nachbarfeld frei ist.
	 * 
	 * @param i
	 *            die Zahl, die verschieben worden soll.
	 * @return true wenn das verschiebbar ist. Sonst false
	 */

	public boolean istVerschiebbar(int i) {
		if (i < 1 || i > 15) {
			throw new WrongNumberException();
		}
		int[] indexNummer = getIndex(i);
		int[] leer = getIndex(0);

		boolean a = Math.abs(indexNummer[0] - leer[0]) == 1 && indexNummer[1] == leer[1];
		boolean b = Math.abs(indexNummer[1] - leer[1]) == 1 && indexNummer[0] == leer[0];
		return a || b;
	}

	/**
	 * 
	 * @param i
	 *            die Zahl, die verschieben worden soll.
	 * @return integer Feld von Index i.
	 */

	public int[] getIndex(int i) {
		int[] indexNummer = { 0, 0 };
		for (int zeile = 0; zeile < 4; zeile++) {
			for (int spalte = 0; spalte < 4; spalte++) {
				if (this.feld[zeile][spalte] == i) {
					indexNummer[0] = zeile;
					indexNummer[1] = spalte;
				}
			}
		}
		return indexNummer;
	}

	/**
	 * Diese Methode schiebt das Plaettchen mit der Nummer i auf den freien
	 * Platz.
	 * 
	 * @param i
	 *            die Zahl, die verschieben worden soll.
	 */

	public void schiebe(int i) {
		if (i < 1 || i > 15) {
			throw new WrongNumberException();
		} else if (!istVerschiebbar(i)) {
			throw new WrongMoveException();
		}
		int[] indexNummer = getIndex(i);
		int[] leer = getIndex(0);
		feld[indexNummer[0]][indexNummer[1]] = 0;
		feld[leer[0]][leer[1]] = i;

	}

	/**
	 * Diese Methode mischt das Spiel, indem sie 100 zufaellige (gueltige) Zuege
	 * durchfuehrt. Anmerkung : Diese Methode garantiert, dass das Puzzle immer
	 * loesbar ist. Wenn man die Plaettchen zufaellig anordnet, ist das nur mit
	 * 50% Wahrscheinlichkeit der Fall.
	 */

	public void mische() {
		int i = 0;
		while (i < 100) {
			double d = Math.random() * 15 + 1;
			int zufaellig = (int) d;
			if (istVerschiebbar(zufaellig)) {
				schiebe(zufaellig);
				i++;
			}
		}
	}

	/**
	 * Erzeugt einen Ausgabesstring des Spielfelds
	 */

	public String toString() {

		String s = "";
		for (int zeile = 0; zeile < 4; zeile++) {
			for (int spalte = 0; spalte < 4; spalte++) {
				s += "|";
				if (this.feld[zeile][spalte] == 0) {
					s += "  ";
				} else {
					s += String.format("%2d", this.feld[zeile][spalte]);
				}
			}
			s += "|\n-------------\n";

		}
		return s;
	}

}
