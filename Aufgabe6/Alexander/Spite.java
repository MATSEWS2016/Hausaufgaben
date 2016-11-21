/**
 * Spite Strategie
 * Kooperiert so lange, bis der Gegner einmal betruegt 
 * @author Alexander Brennecke
 *
 */
public class Spite implements GefStrategie{

	boolean next = true;
	
	
	@Override
	public boolean getNextDecision() {
		return next;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		next = (!decision&&next)?false:next;
	}
	

}
