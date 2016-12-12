
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
		for (int x = 1; x < 9; x++) {
			for (int y = 1; y < 9; y++) {
				Position pos = new Position(x, y);
				if (pos.equals(aktuellePos)) {
					continue;
				} else {
					if (x == aktuelleX) {
						liste.add(new Position(x, y));
					} else if (y == aktuelleY) {
						liste.add(new Position(x, y));
					}
				}
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
