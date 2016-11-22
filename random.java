import java.util.Random;

/**
 * Random-Strategie spielt mit gleicher Wahrscheinlichkeit defect oder
 * cooperate. Keine Strategie, die eine Kooperation etablieren moechte, kann
 * damit bei random Erfolg haben, wird also, wenn sie nicht blind spielt, nicht
 * leichtfertig kooperieren.
 * 
 * @author Intan
 *
 */
public class random implements GefStrategie {
	
	@Override
	public boolean getNextDecision() {
		return new Random().nextBoolean();
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		
	}

}
