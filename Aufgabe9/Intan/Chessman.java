import java.util.ArrayList;

/**
 * Eine abstrakte Klasse der Scachfigur.
 * 
 * @author Intan
 *
 */

abstract class Chessman implements Cloneable {
	private Position position;

	/**
	 * Ein Konstruktor, der eine Schachfigur mit gewuenschter Position erzeugt.
	 * 
	 * @param pos
	 *            Die gewuenschte Position.
	 */

	public Chessman(Position pos) {
		if (!(pos.isValid())) {
			throw new RuntimeException("Die Position ist ungueltig");
		}

		this.position = pos;

	}

	/**
	 * Gibt die Position der Schachfigur zurueck.
	 * 
	 * @return Die Position der Schachfigur.
	 */
	public Position getPosition() {
		return this.position;
	}

	/**
	 * Setzt die Figur auf den angegebenen Punkt.
	 * 
	 * @param pos
	 *            Die gewuenschte Position.
	 * @throws RuntimeException,
	 *             falls das Feld nicht in einem Zug erreicht werden.
	 */
	public void moveTo(Position pos) {
		if (!canMoveTo(pos)) {
			throw new RuntimeException("Das Feld kann nicht in einem Zug erreicht werden");
		}
		this.position = pos;
		
	}

	/**
	 * Gibt die Liste der Position, die mit der Figur in einem Zug erreicht
	 * werden koennen zurueck.
	 * 
	 * @return Die Liste der Position
	 */
	public abstract ArrayList<Position> getMoveList();

	/**
	 * Gibt zurueck, ob die Figur die angegebene Position in einem Zug erreichen
	 * kann.
	 * 
	 * @param pos
	 *            Die gewuenschte Position.
	 * @return true, wenn die Figur die angegebene Position erreichen kann.
	 *         Sonst false.
	 */

	public boolean canMoveTo(Position pos) {
		return getMoveList().contains(pos);
	}

}
