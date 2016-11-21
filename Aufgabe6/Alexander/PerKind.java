
public class PerKind implements GefStrategie{

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
