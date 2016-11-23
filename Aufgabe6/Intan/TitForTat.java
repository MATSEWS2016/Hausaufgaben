/**
 * TitForTat-Strategie : kooperiere im ersten Zug, in jedem weiteren Zug spiele
 * den Zug, den der Gegner bei letzten Mal benutzt hat.
 * 
 * @author Intan
 *
 */
public class TitForTat implements GefStrategie {
	private boolean decision =true;
	
	
	public TitForTat(){
		
	}

	//?
	@Override
	public boolean getNextDecision() {
		return this.decision;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.decision = decision;
	}

}
