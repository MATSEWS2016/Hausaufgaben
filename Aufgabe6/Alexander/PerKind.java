/**
 * PerKind-Strategie
 * Kooperiert zweimal und betruegt dann einmal. Dies geschieht periodisch.
 * @author Alexander Brennecke
 *
 */
public class PerKind implements GefStrategie{

	//Attribute fuer den letzten eigenen Zug und den naechsten
	boolean next = true;
	boolean last = true;
	
	
	@Override
	public boolean getNextDecision() {
		return next;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		boolean temp = last;
		last = (next&&last)?false:true;
		next = temp;
	}
	

}
