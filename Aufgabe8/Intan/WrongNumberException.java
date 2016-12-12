/**
 * Soll geworfen werden, wenn eine Zahl geschoben werden soll, die nicht
 * existiert.
 * 
 * @author Intan
 *
 */

public class WrongNumberException extends RuntimeException {
	public WrongNumberException() {
		super("i liegt nicht zwischen 1 und 15");
	}

}
