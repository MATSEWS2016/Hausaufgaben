/**
 * TitForTat Strategie
 * Macht immer das, was der Gegner in der Runde zuvor getan hat.
 * @author Alexander Brennecke
 *
 */
public class TitForTat implements GefStrategie{

	//Attribut
	boolean last = true;
	
	@Override
	public boolean getNextDecision() {
		return last;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		//naechste Entscheidung = letzte des Gegners
		last = decision;
	}
	

}
