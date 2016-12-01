import java.util.List;

/**
 * Schiebe Algorithmus, des zufaellig einen Nachbarn in das freie Feld schiebt und so versucht die 1 oben links zu platzieren.
 * @author Alexander Brennecke
 *
 */
public class SchiebAlg1 implements Loesungsalgorithmus {

	@Override
	public void loese(Schiebepuzzle puzzle) {
		//Zaehler um zu erfahren, wie viele Zuege benoetigt wurden
		int counter = 0;
		//schiebe, bis 1 an der Stelle 0
		while (puzzle.valueAt(0) != 1) {
			List<Integer> possibleTurns = puzzle.getPossibleTurns();
			int pos = (int) Math.round(Math.random() * (possibleTurns.size() - 1));
			puzzle.schiebe(possibleTurns.get(pos));
			counter++;
		}
		System.out.println("needed "+counter+" moves");
	}
}
