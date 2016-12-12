/**
 * Hier werden die Testfaelle ausgefuehrt.
 * 
 * @author Intan
 */

public class TestFall {

	public static void main(String[] args) {
		Schiebepuzzle puzzle = new Schiebepuzzle();
		puzzle.mische();
		SchiebAlg1 alg1 = new SchiebAlg1();
		alg1.loese(puzzle);

	}

}
