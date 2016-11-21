/**
 * Pavlov-Strategie
 * Kooperiert, wenn er in der Vorrunde das gleiche gemacht hat wie der Gegner.
 * Ansonsten betruegt er
 * @author Alexander Brennecke
 *
 */
public class Pavlov implements GefStrategie{

	boolean next = true;
	
	
	@Override
	public boolean getNextDecision() {
		return next;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		next = (decision == next)?true:false;
	}
	

}
