/**
 * Interface fuer die Strategie eines Spielers
 * @author Alexander Brennecke
 *
 */
public interface GefStrategie {
	/**
	 * gibt die naechste Entscheidung zurueck
	 * @return true = kooperiert, false = betruegt
	 */
	boolean getNextDecision();
	
	/**
	 * Teilt der Strategie die letze Entscheidung des Gegners mit
	 * @param decision true = kooperiert, false = betruegt
	 */
	void setOpponentsLastDecision(boolean decision);
}
