/**
 * TitForTat-Strategie : kooperiere im ersten Zug, in jedem weiteren Zug spiele
 * den Zug, den der Gegner bei letzten Mal benutzt hat.
 * 
 * @author Intan
 *
 */
public class TitForTat implements GefStrategie {
	private boolean erster=true;
	private boolean opponentLastDecision;
	
	public TitForTat(){
		
	}

	@Override
	public boolean getNextDecision() {
		return this.opponentLastDecision;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentLastDecision = decision;
	}

}
