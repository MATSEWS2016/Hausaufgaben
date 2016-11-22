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

	private boolean opponentLastDecision;
	private int count = 0;

	public PerKind() {
		count++;
	}

	// FIXME
	@Override
	public boolean getNextDecision() {
		return !(count++ % 3 == 0);
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentLastDecision = decision;
	}

}
