/**
 * Random-Strategie spielt mit gleicher Wahrscheinlichkeit defect oder
 * cooperate. Keine Strategie, die eine Kooperation etablieren moechte, kann
 * damit bei random Erfolg haben, wird also, wenn sie nicht blind spielt, nicht
 * leichtfertig kooperieren.
 * 
 * @author Intan
 *
 */
public class Random implements GefStrategie {
	private boolean erster;
	private boolean opponentLastDecision;
	
	public Random(){
		
	}

	@Override
	public boolean getNextDecision() {
		if (Math.random() < 1 / (double) 2) {
			this.erster = true;
			return true;
		}
		this.erster = false;
		return false;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentLastDecision = decision;

	}

}
