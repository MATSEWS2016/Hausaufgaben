import java.util.Arrays;
/**
 * Repraesentiert ein Poker Blatt
 * @author Alexander
 *
 */
public class Blatt {
	
	private int[]  cards;
	
	/**
	 * Konstruktor kopiert das uebergebene Array in das Klassen Attribut.
	 * @param cards die Karten des Spielers
	 */
	public Blatt(int [] cards){
		if(cards.length == 3){
			for(int i : cards){
				if(i<2||i>14){
					throw new ArithmeticException(i+ "is not allowed. Just values from 2 to 14!");
				}
			}
			this.cards = new int[3];
			System.arraycopy(cards, 0, this.cards, 0, 3);
		}else{
			throw new ArithmeticException("Invalid field length of parameter.");
		}
	}
	
	/**
	 * Erzeugt eine Ausgabe
	 */
	public String toString(){
		String retval = Arrays.toString(cards);
		return retval.replaceAll("\\[", "").replaceAll("\\]", "");
	}
	
	/**
	 * Gibt die Karten zurueck
	 * @return
	 */
	public int[] getCards(){
		return cards;
	}

}
