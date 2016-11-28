import java.util.Comparator;

/**
 * BlattVergleich vergleicht zwei Poker Blaetter nach Wertigkeit
 * Bei dem Algorithmus ist das Haupt Augenmerk auf Flexibilitaet und nicht auf Performance gelegt.
 * Die Anzahl der For-Schleifen verlangsamt den Algorithmus kaum, da sie sehr kurz sind. Diese wurde mit Benchmark Tests getestet.
 * @author Alexander
 *
 */
public class BlattVergleich implements Comparator<Blatt> {

	@Override
	public int compare(Blatt b1, Blatt b2) {
		//Liest die Karten der Blaetter aus
		int[][] cards = { b1.getCards(), b2.getCards() };
		//zaehlt die Hauefigkeit jeder Karte
		int[][] points = countCards(cards);

		int retval = 0;
		//sucht die High Card, also die hoechste einzelne Karte
		int[] highCard = find(points,1);
		
		//ueberprueft ob es einen Drilling gibt, dann Paar, dann High Card
		for(int i =3; i>=1;i--){
			int[] has = find(points,i);
			//vergleicht die Ergebnisse
			retval = compare(has); 
			//wenn beide Spieler die Karte haben wird die High Card ueberprueft
			if(retval == 0 && has[0] != -1){
				return compare(highCard);
			}else if (retval != 0){
				return retval;
			}else{
				continue;
			}
		}
		
		return retval;
	}
	
	/**
	 * Vergleicht den ersten und zweiten Wert des gegebenen Arrays miteinander.
	 * @param compare int Array
	 * @return 0 wenn int[0] ==int[1]; <0 wenn int[0] < int[1]; >0 wenn int[0]>int[1]
	 */
	private int compare(int[] compare){
		return Integer.compare(compare[0],compare[1]); 
	}
	
	/**
	 * Sucht, ob das points Array an einer Position die Wertigkeit count hat.
	 * @param points int Array, eine Dimension pro Spieler
	 * @param count nach der Hauefigkeit wird gesucht
	 * @return die hoechste Position, an der es die Wertigkeit hat. Fuer jedes sub int[] in points. -1, fall es garnicht auftritt. 
	 */
	private int[] find(int[][] points, int count){
		int[] retval = {-1,-1};
		//erst spieler 1, dann spieler 2
		for(int i = 0; i<retval.length;i++){
			for(int x = points[i].length-1; x>=0;x--){
				if(points[i][x]==count){
					retval[i] = x;
					break;
				}
			}
		}
		return retval;
	}
	
	/**
	 * Zaehlt, wie oft eine Wertigkeit im cards Array vor kommt
 	 * @param cards die Karten der Spieler
	 * @return die Haeufigkeit der einzelnen Karten pro Spieler
	 */
	private int[][] countCards(int[][] cards) {
		int[][] retval = new int[cards[0].length][14];
		for (int i = 0; i<cards.length;i ++) {
			for(int card : cards[i]){
				retval[i][card-1] ++;
			}
		}
		return retval;
	}
}