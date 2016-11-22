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
	private boolean lastDecision;
	private boolean nextDecision = true;

	
	@Override
	public boolean getNextDecision() {
		lastDecision = nextDecision;
		return nextDecision;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		if(lastDecision != decision){
			nextDecision = false;
		}else{
			nextDecision = true;
		}
	}

}
