/**
 * PerKind-Strategie : spiele periodisch [kooperieren, kooperieren,
 * defektieren]. Diese Strategie versucht, den Gegner "in Sicherheit" zu weigen
 * und dann zuzuschlagen, in der Hoffnung, dass er gelegentliches defektieren
 * hinnimmt und dich dann wieder auf Kooperation einlaesst.
 * 
 * @author Intan
 *
 */
public class PerKind implements GefStrategie {

	private boolean erster;
	private boolean opponentLastDecision;
	private int count = 0;
	
	public PerKind(){
		
	}

	@Override
	public boolean getNextDecision() {
		
		if (count == 0) {
			this.erster = true;
			count++;
			return true;
		} else if (count == count + 1) {
			this.erster = true;
			count++;
			return true;
		} else if (count == count + 2) {
			this.erster = false;
		}
		return false;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentLastDecision = decision;
	}

}
