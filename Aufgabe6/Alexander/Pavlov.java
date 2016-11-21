
public class Pavlov implements GefStrategie{

	boolean next = true;
	
	
	@Override
	public boolean getNextDecision() {
		return next;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		next = (decision == next)?true:false;
	}
	

}
