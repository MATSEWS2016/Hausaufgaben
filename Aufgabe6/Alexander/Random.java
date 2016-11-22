/**
 * Random Strategie
 * Betruegt oder kooperiert nach dem Zufallsprinzip. Die Entscheidung des Gegners spielt keine Rolle.
 * @author Alexander Brennecke
 *
 */
public class Random implements GefStrategie{
    
    private java.util.Random random;
    
    public Random(){
        random = new java.util.Random();
    }

	@Override
	public boolean getNextDecision() {
		return random.nextBoolean();
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
	}
	

}
