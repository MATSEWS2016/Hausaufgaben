import java.util.Comparator;

/**
 * BlattVergleich vergleicht zwei Poker Blaetter nach Wertigkeit
 * @author Alexander
 *
 */
public class BlattVergleich implements Comparator<Blatt> {

	@Override
	public int compare(Blatt b1, Blatt b2) {
		return calcPoints(b1)-calcPoints(b2);
	}
	
	/**
	 * Berechnet die Punkte für ein Blatt. Diese Berechnen sich wie folgt:
	 * 	Drilling: Karte * 10000 (20000-14000)
	 *  Paar: Karte * 100 + Karte, die nicht zum Paar gehoert (203 - 1413)
	 *  Sonst: Summe der Karten
	 * @param b, das Blatt, dessen Punkte berechner werden sollen.
	 * @return den Wert des Blattes anhand der bereits beschriebenen Regelung.
	 */
	private int calcPoints(Blatt b){
		int[] cards = b.getCards();
		
		if(compare(cards, 0,1,2)){
			return 10000*cards[0];
		}else if(compare(cards, 0,1)){
			return 100*cards[0] + cards[2];
		}else if(compare(cards,0,2)){
			return 100*cards[0] + cards[1];
		}else if(compare(cards,1,2)){
			return 100*cards[1] + cards[0];
		}else{
			return cards[0]+cards[1]+cards[2];
		}
		
	}
	
	/**
	 * Ueberprueft ob das uebergebene array an den uebergebenen positionen identisch ist.
	 * @param ints das Array, das ueberprueft wird
	 * @param positions die Positionen, die ueberprueft werden sollen.
	 * @return true= hat an allen uebergeben stellen den gleichen Wert. Sonst false.
	 */
	private boolean compare(int[] ints, int... positions){
		int comperator = ints[positions[0]];
		for(int i = 0; i<positions.length;i++){
			if(ints[positions[i]]!=comperator){
				return false;
			}
		}
		return true;
	}
}