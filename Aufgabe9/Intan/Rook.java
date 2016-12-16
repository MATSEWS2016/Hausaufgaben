
/**
 * Diese Klasse erbt von der Klasse Chessman
 * @author Intan
 *
 */

import java.util.ArrayList;

public class Rook extends Chessman {

	/**
	 * Der Konstruktor. Siehe Chessman.
	 * 
	 * @param pos
	 *            Die gewuenschte Position.
	 */

	public Rook(Position pos) {
		super(pos);

	}

	/**
	 * Die Liste der Position. Siehe Chessman.
	 */

	@Override
	public ArrayList<Position> getMoveList() {

		ArrayList<Position> liste = new ArrayList<>();
		Position aktuellePos = this.getPosition();
		int aktuelleX = aktuellePos.getX();
		int aktuelleY = aktuellePos.getY();
		for (int i = 1; i < 9; i++) {
			if (i != aktuelleX) {
				liste.add(new Position(i, aktuelleY));
			}

			if (i != aktuelleY) {
				liste.add(new Position(aktuelleX, i));
			}
		}

		return liste;
	}

	/**
	 * Gibt eine Stringdarstellung der Position zurueck.
	 * 
	 * @return Die Stringdarstellung der Position.
	 */

	public String toString() {
		return "Turm: " + this.getPosition().toString();
	}

}
