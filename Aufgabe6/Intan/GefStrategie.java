/**
 * Das Rechenoperation Interface wird implementiert.
 * 
 * @author Intan
 *
 */

public interface GefStrategie {
	
	/**
	 * Diese Methode gibt als Ergebnis die nächsteeigene Spielentscheidung zurueck.
	 * @return
	 */
	
	boolean getNextDecision();

	/**
	 * In dieser Methode wird dem Spielerder letzte Zug des Gegners mitgeteilt.
	 * @param decision
	 */
	
	void setOpponentsLastDecision(boolean decision);
	

}
