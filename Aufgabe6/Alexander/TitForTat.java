
public class TitForTat implements GefStrategie{

	boolean last = true;
	
	@Override
	public boolean getNextDecision() {
		return last;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		last = decision;
	}
	

}
