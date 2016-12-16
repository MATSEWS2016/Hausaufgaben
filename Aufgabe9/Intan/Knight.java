/**
 * Diese Klasse erbt von der Klasse Chessman
 * @author Intan
 *
 */
import java.util.ArrayList;

public class Knight extends Chessman {

	/**
	 * Der Konstruktor. Siehe Chessman.
	 * 
	 * @param pos
	 *            Die gewuenschte Position.
	 */

	public Knight(Position pos) {
		super(pos);
	}

	/**
	 * Die Liste der Position. Siehe Chessman.
	 */

	@Override
	public ArrayList<Position> getMoveList() {
		ArrayList<Position> liste = new ArrayList<Position>();
		Position aktuellePos = this.getPosition();
		int aktuelleX = aktuellePos.getX();
		int aktuelleY = aktuellePos.getY();
		for (int x = 1; x < 9; x++) {
			for (int y = 1; y < 9; y++) {
				if ((Math.abs(aktuelleX - x) == 2) && (Math.abs(aktuelleY - y) == 1)) {
					liste.add(new Position(x, y));
				} else if ((Math.abs(aktuelleY - y) == 2) && (Math.abs(aktuelleX - x) == 1)) {
					liste.add(new Position(x, y));
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

		return "Springer: " + this.getPosition().toString();

	}

}
