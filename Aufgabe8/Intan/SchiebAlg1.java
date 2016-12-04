
public class SchiebAlg1 implements Loesungsalgorithmus {

	@Override
	public void loese(Schiebepuzzle puzzle) {
		System.out.println("Vor dem Loesen:" + "\n" + puzzle);
		int[] eins = puzzle.getIndex(1);
		while (eins[0] != 0 || eins[1] != 0) {
			double d = Math.random() * 15 + 1;
			int i = (int) d;
			if (puzzle.istVerschiebbar(i)) {
				puzzle.schiebe(i);
				eins = puzzle.getIndex(1);
			}
		}

		System.out.println("Nach dem Loesen:" + "\n" + puzzle);
	}

}
