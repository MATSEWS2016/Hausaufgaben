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

	GefStrategie strategy1, strategy2;

	/**
	 * Erzeugt ein GefDilemma-Objekt fuer das die Strategien der beiden Spieler
	 * bestimmt werden.
	 * 
	 * @param strategie1
	 *            Strategie von Spieler 1
	 * @param strategie2
	 *            Strategie von Spieler 2
	 */

	public GefDilemma(GefStrategie strategy1, GefStrategie strategy2) {
		this.strategy1 = strategy1;
		this.strategy2 = strategy2;
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

	// ?
	public void spiele(int n) {
		int points1 = 0;
		int points2 = 0;
		for (int i = 0; i < n; i++) {
			boolean player1 = this.strategy1.getNextDecision();
			boolean player2 = this.strategy2.getNextDecision();

			// Kooperieren beide Spieler, erhalten beide 2 Strafpunkte.
			if (player1 && player2) {
				points1 += 2;
				points2 += 2;

				// Betruegen beide Spieler, erhalten beide 4 Strafpunkte.
			} else if (!player1 && !player2) {
				points1 += 4;
				points2 += 4;

				// Kooperiert ein Spieler und der andere betruegt, so erhaelt
				// der betruegende Spieler 0 Strafpunkte, der kooperiende
				// erhaelt 5 Strafpunkte.
			} else if (player1 && !player2) {
				points1 += 5;
			} else {
				points2 += 5;
			}
			this.strategy1.setOpponentsLastDecision(player2);
			this.strategy2.setOpponentsLastDecision(player1);
		}
		
		System.out.println("Strafpunkte Spieler1: " + points1);
		System.out.println("Strafpunkte Spieler2: " + points2);
		if (points1 > points2) {
			System.out.println("Spieler2 hat gewonnen.");
		} else if (points1 < points2) {
			System.out.println("Spieler1 hat gewonnen.");
		} else {
			System.out.println("keiner gewinnt.");
		}
	}

}
