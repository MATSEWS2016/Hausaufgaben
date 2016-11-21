/**
 * Die Klasse, die die Spieler abwechselnd ziehen laesst und am Ende den Sieger
 * ermittelt.
 * 
 * @author Intan
 *
 */

public class GefDilemma {

	/**
	 * Attribut : Objekte von GefStrategie-Interface als Typparameter
	 */

	GefStrategie spieler1, spieler2;
	private int StrafpunkteSpieler1 = 0;
	private int StrafpunkteSpieler2 = 0;

	/**
	 * Im Konstruktor werden zwei Objekte der Klasse GefStrategie uebergeben,
	 * die die Strategie der beiden Spieler bestimmen.
	 */

	public GefDilemma(){
		
	}
	
	public GefDilemma(GefStrategie spieler1, GefStrategie spieler2) {
		this.spieler1 = spieler1;
		this.spieler2 = spieler2;
	}

	/**
	 * Diese Methode fuehrt n Spielrunden aus. Das darf den Spielern nicht
	 * bekannt sein. Eine Spielrunde besteht aus : Abfrage der Spieltaktik
	 * beider Spieler, Verteilen der Punkte, beide Spieler bekommen den Zug des
	 * gegnerischen Spielers mitgeteilt und ueberdenken so ihre Taktik fuer die
	 * naechste Runde.
	 * 
	 * Nach den n Spielrunden wird das Ergebnis auf dem Bildschirm ausgegeben.
	 * Es gewinnt der Spieler mit den wenigsten Strafpunkten.
	 * 
	 * @param n
	 *            die uebergebene n
	 */

	public void spiele(int n) {
		for (int i = 0; i < n; i++) {
			if (spieler1.getNextDecision() && spieler2.getNextDecision()) {
				this.StrafpunkteSpieler1 += 2;
				this.StrafpunkteSpieler2 += 2;

			} else if (!(spieler1.getNextDecision() && spieler2.getNextDecision())) {
				this.StrafpunkteSpieler1 += 4;
				this.StrafpunkteSpieler2 += 4;

			} else if (!(spieler1.getNextDecision()) && spieler2.getNextDecision()) {
				this.StrafpunkteSpieler1 += 0;
				this.StrafpunkteSpieler2 += 5;
			}
		}
		System.out.printf("Strafpunkte fuer Spieler1 ist " + this.StrafpunkteSpieler1 + "\n"
				+ "Strafpunkte fuer Spieler2 ist " + this.StrafpunkteSpieler2);

	}

}
