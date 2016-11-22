/**
 * Spite-Strategie : kooperiere im ersten Zug, dann kooperiere, solange der
 * Gegner noch nicht defektiert hat, danach defektiere immer.
 * 
 * @author Intan
 *
 */

public class Spite implements GefStrategie {
	private boolean decision = true;
	


	@Override
	public boolean getNextDecision() {
		return this.decision;

	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		if(!decision){
		this.decision=false;
		}
	}

}
