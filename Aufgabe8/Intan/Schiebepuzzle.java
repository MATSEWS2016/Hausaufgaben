import java.util.ArrayList;

public class Schiebepuzzle {

	private int[][] feld;

	public Schiebepuzzle() {
		int[][] array = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 0 } };
		this.feld = array.clone();

	}

	public boolean istVerschiebbar(int i) {
		if (i < 1 || i > 15) {
			throw new WrongNumberException();
		}
		int[] indexNummer = getIndex(i);
		int[] leer = getIndex(0);

		boolean a = Math.abs(indexNummer[0] - leer[0]) == 1 && indexNummer[1] == leer[1];
		boolean b = Math.abs(indexNummer[1] - leer[1]) == 1 && indexNummer[0] == leer[0];
		return a || b;
	}

	public int[] getIndex(int i) {
		int[] indexNummer = { 0, 0 };
		for (int zeile = 0; zeile < 4; zeile++) {
			for (int spalte = 0; spalte < 4; spalte++) {
				if (this.feld[zeile][spalte] == i) {
					indexNummer[0] = zeile;
					indexNummer[1] = spalte;
				}
			}
		}
		return indexNummer;
	}

	public void schiebe(int i) {
		if (i < 1 || i > 15) {
			throw new WrongNumberException();
		} else if (!istVerschiebbar(i)) {
			throw new WrongMoveException();
		}
		int[] indexNummer = getIndex(i);
		int[] leer = getIndex(0);
		feld[indexNummer[0]][indexNummer[1]] = 0;
		feld[leer[0]][leer[1]] = i;

	}

	public void mische() {
		for (int i = 0; i < 100; i++) {
			double d = Math.random() * 15 + 1;
			int a = (int) d;
			if (istVerschiebbar(a)) {
				schiebe(a);
			}
		}
	}

	public String toString() {

		String s = "";
		for (int zeile = 0; zeile < 4; zeile++) {
			for (int spalte = 0; spalte < 4; spalte++) {
				s += "|";
				if (this.feld[zeile][spalte] == 0) {
					s += "  ";
				} else {
					s += String.format("%2d", this.feld[zeile][spalte]);
				}
			}
			s += "|\n-------------\n";

		}
		return s;
	}

}
