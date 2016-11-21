import java.util.Arrays;

/**
 * Spielklasse des Spiels Gefangenen-Dilemma
 * 
 * @author Alexander
 *
 */
public class GefDilemma {
	// Speichert die Strategien der Spieler
	private GefStrategie[] players;

	/**
	 * Konstruktor
	 * 
	 * @param player1
	 *            Strategie des ersten Spielers
	 * @param player2
	 *            Strategie des zweiten Spielers
	 */
	public GefDilemma(GefStrategie player1, GefStrategie player2) {
		players = new GefStrategie[2];
		players[0] = player1;
		players[1] = player2;
	}

	/**
	 * Spielt mehrere Runden und addiert die Punkte auf.
	 * 
	 * @param n,
	 *            Anzahl der Runden, die gespielt werden sollen.
	 */
	public void spiele(int n) {
		int[] points = { 0, 0 };

		for (int i = 0; i < n; i++) {
			boolean[] decisions = { players[0].getNextDecision(), players[1].getNextDecision() };
			calcPoints(decisions, points);
			informOtherStrategie(decisions);
		}

		System.out.println(Arrays.toString(points));
	}

	/**
	 * Tauscht die Information ueber die Entscheidungen der Gegner untereinander
	 * aus
	 * 
	 * @param decisions
	 *            die Entscheidungen der letzten Runde
	 */
	private void informOtherStrategie(boolean[] decisions) {
		players[0].setOpponentsLastDecision(decisions[1]);
		players[1].setOpponentsLastDecision(decisions[0]);
	}

	/**
	 * Berechnet die Punkte anhand der definierten Rechenmethoden.
	 * 
	 * @param decisions
	 *            die Entscheidungen
	 * @param points
	 *            die bereits vorhandenen Punkte
	 */
	private void calcPoints(boolean[] decisions, int[] points) {
		if (decisions[0] && decisions[1]) {
			addPoints(2, points);
		} else if (!(decisions[0] || decisions[1])) {
			addPoints(4, points);
		} else {
			int p = (decisions[0]) ? 1 : 0;
			points[p] = points[p] + 5;
		}
	}

	/**
	 * Addiert jedem Element in dem uebergebenen Array die uebergebenen Punkte
	 * 
	 * @param points
	 *            die Punkte die addiert werden
	 * @param players
	 *            das Array, zu dem sie addiert werden
	 */
	private void addPoints(int points, int[] players) {
		for (int i = 0; i < players.length; i++) {
			players[i] = players[i] + points;
		}
	}

}
