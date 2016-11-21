/**
 * Pavlov-Strategie : kooperiere im ersten Zug, dann nur, wenn beide Spieler
 * denselben Zug gemacht haben. Pavlov verfolgt einen aehnlichen Grundgedanken
 * wie tit-for-tat, stellt jedoch strengere Anforderungen an die eigene
 * Kooperationswilligkeit. Nur nach einer erfolgreichen Kooperation wird weiter
 * kooperiert, d.h. die Strategie reagiert auf Ausbeutungsversuche mit
 * Nichtkooperation und macht dann von sich aus keinen Versuch, eine Kooperation
 * wieder zu etablieren.
 * 
 * @author Intan
 *
 */
public class Pavlov implements GefStrategie {
	private boolean erster=true;
	private boolean zweiter;
	private boolean opponentLastDecision;
	
	public Pavlov(){
	
	}

	@Override
	public boolean getNextDecision() {
		if (erster == zweiter) {
			this.zweiter=true;
			return true;
		}
		this.zweiter=false;
		return false;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentLastDecision = decision;
	}

}
