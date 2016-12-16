/**
 * Die Klasse Position hat als Inhalt die x-y Position einer Schachfigur.
 * 
 * @author Intan
 *
 */
public class Position {

	private int x, y;

	/**
	 * Ein Konstruktor, der x-y Position einer Schachfigur erzeugt.
	 * 
	 * @param x
	 *            Die x-Koordinate der Position.
	 * @param y
	 *            Die y-Koordinate der Position.
	 * @throws IllegalArgumentException
	 *             falls die Position ungueltig ist.
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		if (!this.isValid()) {
			throw new RuntimeException("Die Position ist nicht innerhalb des Schachbretts");
		}

	}

	/**
	 * Gibt die x-Koordinate der Position zurueck.
	 * 
	 * @return Die x-Koordinate.
	 */

	public int getX() {
		return this.x;
	}

	/**
	 * Gibt die y-Koordinate der Position zurueck.
	 * 
	 * @return Die y-Koordinate.
	 */

	public int getY() {
		return this.y;
	}

	/**
	 * Gibt zurueck, ob die Positionen this und p gleich sind.
	 * 
	 * @param p
	 *            eine Position der Schachfigur.
	 * @return true wenn p gleich wie this ist. Sonst false.
	 */
	public boolean equals(Object o) {
		if(o instanceof Position){
			Position p = ((Position)o);
		    return p.x == x && p.y == y;
		}
		return false;
	}

	/**
	 * Gibt zuruck, ob die Position gueltig ist.
	 * 
	 * @return true, wenn die Position innerhalb des Schachbretts ist. Sonst
	 *         false.
	 * 
	 */
	public boolean isValid() {
		if ((this.x >= 1 && this.x <= 8) && (this.y >= 1 && this.y <= 8)) {
			return true;
		}
		return false;
	}

	/**
	 * Gibt eine Stringdarstellung der Position zurueck.
	 * 
	 * @return Die Stringdarstellung der Position.
	 */

	public String toString() {
		return String.format("(%d/%d)", this.x, this.y);
	}

}
