import java.util.ArrayList;
import java.util.List;

/**
 * Erzeugt ein 4x4 Schiebepuzzel und stellt Methoden bereit um dieses durch schieben zu loesen.
 * @author Alexander Brennecke
 *
 */
public class Schiebepuzzle {
	//Spielfeld
	int[][] field;
	//freies Feld
	int freeField = 15;

	/**
	 * Erzeugt ein neues Spielfeld und mischt es.
	 */
	public Schiebepuzzle() {
		int[][] tempField = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, -1 } };
		field = tempField.clone();
		mische();
	}

	/**
	 * Schiebt die uebergebene Zahl in das frei Feld, wenn das freie Feld angrenzt.
	 * @param i die Zahl, die verschoben werden soll.
	 * @throws WrongNumberException, falls die Zahl nicht 1-15 ist.
	 * @throws WrongMoveException, falls das Nachbarfeld nicht frei ist.
	 */
	public void schiebe(int i) {
		WrongNumberException.check(i);
		if (istVerschiebbar(i)) {
			int pos = positionOf(i);
			//Aktualisieren des freien Feldes auf neuen Wert
			update(freeField, i);
			//Aktualisieren der Informationen ueber das freie Feld
			update(pos, -1);
			freeField = pos;
		} else {
			throw new WrongMoveException();
		}
	}
	
	/**
	 * Setzt den Wert an der gegebenen Position auf den gegebenen Wert
	 * @param position Position, welche aktualisiert werden soll
	 * @param value der neue Wert
	 */
	private void update(int position, int value) {
		int x = ((int) position / 4);
		int y = position % 4;
		field[x][y] = value;
	}

	/**
	 * Ueberprueft ob eine Zahl wirklich verschiebbar ist, also ob das Nachbarfeld frei ist.
	 * @param i die Zahl, die verschoben werden soll
	 * @return true = kann verschoeben werden. Sont false;
	 */
	public boolean istVerschiebbar(int i) {
		WrongNumberException.check(i);
		//Position der Zahl
		int position = positionOf(i);
		//Ueberpruefen ob Nachbarfeld das leere ist
		if (position + 4 == freeField || position - 4 == freeField) {
			return true;
		} else if ((freeField == position + 1)) {
			return !((position + 1) % 4 == 0);
		} else if (freeField == position - 1) {
			return !((position) % 4 == 0);
		}
		return false;
	}

	/**
	 * Mischt das Spielfeld mit 100 gueltigen Zuegen.
	 */
	private void mische() {
		//letze Zahl, die geschoben wurde wird zwischen gespeichert
		//erhoeht den "Mischfaktor" enorm, da so nicht eine Zahl mehrmals hintereinander hin und her geschoben wird
		int last = -1;
		for (int i = 0; i < 100; i++) {
			//welche Zahlen sind moeglich
			List<Integer> possibleTurns = getPossibleTurns();
			int num = -1;
			do {
				//zufaellige Zahl waehlen
				int pos = (int) Math.round(Math.random() * (possibleTurns.size() - 1));
				num = possibleTurns.get(pos); 
			} while (num == last);
			last = num;
			//zahl verschieben
			schiebe(num);
		}
	}

	/**
	 * Gibt die Position der uebergebenen Zahl im Spielfeld zurueck
	 * @param i die Zahl, die gesucht ist
	 * @return 0-15 (position im Spielfeld)
	 */
	private int positionOf(int i) {
		int retval = 0;
		for (int[] row : field) {
			for (int pos = 0; pos < 4; pos++) {
				if (row[pos] == i) {
					return retval;
				}
				retval++;
			}
		}
		return -1;
	}

	/**
	 * Liste den Wert im Spielfeld aus
	 * @param position Position (0-15)
	 * @return die Zahl an der Position
	 */
	public int valueAt(int position) {
		if(position<0||position>15){
			throw new WrongNumberException();
		}
		int x = ((int) position / 4);
		int y = position % 4;
		return field[x][y];
	}

	
	/**
	 * Berechnet die moeglichen Spielzuege
	 * @return eine Liste der Zahlen, die verschoben werden koennen
	 */
	public List<Integer> getPossibleTurns() {
		List<Integer> retval = new ArrayList<>();
		//oberhalb des freien Feldes
		if (freeField - 4 > 0) {
			retval.add(valueAt(freeField - 4));
		}
		//unterhalb des freien Feldes
		if (freeField + 4 < 16) {
			retval.add(valueAt(freeField + 4));
		}

		//rechts, links oder beides
		if (freeField % 4 == 0) {
			retval.add(valueAt(freeField + 1));
		} else if (freeField % 4 == 3) {
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
		for(int[] i : field){
			String row = "|";
			for(int num : i){
				if(num == -1){
					row = row +"  ";
				}else if(num>=10){
					row = row + num;
				}else{
					row = row +" "+num;
				}
				row = row +"|";
			}
			retval = retval + row + "\n";
			retval = retval + "-------------\n";
		}
		return retval;
	}
}
