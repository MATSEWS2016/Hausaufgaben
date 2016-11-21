/**
 * Spite-Strategie : kooperiere im ersten Zug, dann kooperiere, solange der
 * Gegner noch nicht defektiert hat, danach defektiere immer.
 * 
 * @author Intan
 *
 */

public class Spite implements GefStrategie {
	private boolean erster = true;
	private boolean opponentLastDecision;
	
	public Spite(){
		
	}

	@Override
	public boolean getNextDecision() {
		if(this.opponentLastDecision){
			this.erster=true;
			return true;
		}else if(!this.opponentLastDecision){
			this.erster=false;
		}
		return false;

	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentLastDecision = decision;
	}

}
