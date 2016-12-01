/**
 * Just a test class
 * @author Alexander Brenneckeg xd,µ
 *
 */
public class Test {

	public static void main(String[] args) {
		Schiebepuzzle puzzle = new Schiebepuzzle();
		System.out.println(puzzle);
		SchiebAlg1 alg1 = new SchiebAlg1();
		alg1.loese(puzzle);
		System.out.println(puzzle);
	}
}
