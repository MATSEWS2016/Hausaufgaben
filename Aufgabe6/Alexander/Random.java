/**
 * Random Strategie
 * Betruegt oder kooperiert nach dem Zufallsprinzip. Die Entscheidung des Gegners spielt keine Rolle.
 * @author Alexander Brennecke
 *
 */
public class Random implements GefStrategie{

	@Override
	public boolean getNextDecision() {
		return Math.random()*100 < 5	;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
	}
	

}
