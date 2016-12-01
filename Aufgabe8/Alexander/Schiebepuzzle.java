import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Erzeugt ein 4x4 Schiebepuzzel und stellt Methoden bereit um dieses durch
 * schieben zu loesen.
 * 
 * @author Alexander Brennecke
 *
 */
public class Schiebepuzzle {
	// Spielfeld
	int[] field;
	// freies Feld
	int freeField = 15;

	/**
	 * Erzeugt ein neues Spielfeld und mischt es.
	 */
	public Schiebepuzzle() {
		int[] tempField = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, -1 };
		field = tempField.clone();
		mische();
	}

	/**
	 * Schiebt die uebergebene Zahl in das frei Feld, wenn das freie Feld
	 * angrenzt.
	 * 
	 * @param i
	 *            die Zahl, die verschoben werden soll.
	 * @throws WrongNumberException,
	 *             falls die Zahl nicht 1-15 ist.
	 * @throws WrongMoveException,
	 *             falls das Nachbarfeld nicht frei ist.
	 */
	public void schiebe(int i) {
		WrongNumberException.check(i);
		if (istVerschiebbar(i)) {
			int pos = positionOf(i);
			// Aktualisieren des freien Feldes auf neuen Wert
			field[freeField] = i;
			// Aktualisieren der Informationen ueber das freie Feld
			field[pos] = -1;
			freeField = pos;
		} else {
			throw new WrongMoveException();
		}
	}

	/**
	 * Ueberprueft ob eine Zahl wirklich verschiebbar ist, also ob das
	 * Nachbarfeld frei ist.
	 * 
	 * @param i
	 *            die Zahl, die verschoben werden soll
	 * @return true = kann verschoeben werden. Sont false;
	 */
	public boolean istVerschiebbar(int i) {
		WrongNumberException.check(i);
		// Ueberprueft ob zu verschiebene Zahl
		return getPossibleTurns().contains(new Integer(i));
	}

	/**
	 * Mischt das Spielfeld mit 100 gueltigen Zuegen.
	 */
	private void mische() {
		// letze Zahl, die geschoben wurde wird zwischen gespeichert
		// erhoeht den "Mischfaktor" enorm, da so nicht eine Zahl mehrmals
		// hintereinander hin und her geschoben wird
		Integer last = -1;
		for (int i = 0; i < 100; i++) {
			// welche Zahlen sind moeglich
			List<Integer> possibleTurns = getPossibleTurns();

			// Letzte geschobene Zahl wird geloescht
			if (last != -1) {
				possibleTurns.remove(last);
			}

			// zufaellige Zahl waehlen
			int pos = (int) Math.round(Math.random() * (possibleTurns.size() - 1));
			int num = possibleTurns.get(pos);
			last = num;

			// zahl verschieben
			schiebe(num);
		}
	}

	/**
	 * Gibt die Position der uebergebenen Zahl im Spielfeld zurueck
	 * 
	 * @param i
	 *            die Zahl, die gesucht ist
	 * @return 0-15 (position im Spielfeld)
	 */
	private int positionOf(int zahl) {
		return Arrays.asList(field).indexOf(zahl);
	}

	/**
	 * Liste den Wert im Spielfeld aus
	 * 
	 * @param position
	 *            Position (0-15)
	 * @return die Zahl an der Position
	 */
	public int valueAt(int position) {
		return field[position];
	}

	/**
	 * Berechnet die moeglichen Spielzuege
	 * 
	 * @return eine Liste der Zahlen, die verschoben werden koennen
	 */
	public List<Integer> getPossibleTurns() {
		List<Integer> retval = new ArrayList<>();
		// oberhalb des freien Feldes
		if (freeField - 4 >= 0) {
			retval.add(valueAt(freeField - 4));
		}
		// unterhalb des freien Feldes
		if (freeField + 4 < 16) {
			retval.add(valueAt(freeField + 4));
		}

		// rechts, links oder beides
		if (freeField% 4 == 0) {
			retval.add(valueAt(freeField + 1));
		} else if (freeField% 4 == 3) {
			retval.add(valueAt(freeField - 1));
		} else {
			retval.add(valueAt(freeField + 1));
			retval.add(valueAt(freeField - 1));
		}

		return retval;
	}

	/**
	 * Erzeugt einen Ausgabesstring des Spielfelds
	 */
	public String toString() {
		String retval = "";
		for (int i = 0; i<field.length;i+=4) {
			String row = "|";
			for (int y = 0; y<4;y++) {
				int num = field[i+y];
				if (num == -1) {
					row = row + "  ";
				} else if (num >= 10) {
					row = row + num;
				} else {
					row = row + " " + num;
				}
				row = row + "|";
			}
			retval = retval + row + "\n";
			retval = retval + "-------------\n";
		}
		return retval;
	}
}
