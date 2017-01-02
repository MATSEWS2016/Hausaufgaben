/**
 * Diese Klasse beinhaltet die Koordinaten aller Eckpunkte von Koch-Kurve.
 * 
 * @author Intan
 */

public class Kochkurve {

	public static void kochKurve(double ax, double ay, double bx, double by, double rek) {
		if (rek == 0) {
			System.out.printf("(" + "%.1f" + "/" + "%.1f" + ")", ax, ay);
		} else {
			// Abstand
			double xV = bx - ax;
			double yV = by - ay;

			// x rechnen
			double x1 = ax + xV / 3;
			double x2 = ax + xV / 2 + (Math.sin(Math.PI / 3)) * (yV / 3);
			double x3 = bx - xV / 3;

			// y rechnen
			double y1 = ay + yV / 3;
			double y2 = ay + yV / 2 - (Math.sin(Math.PI / 3)) * (xV / 3);
			double y3 = by - yV / 3;

			kochKurve(ax, ay, x1, y1, rek - 1);
			kochKurve(x1, y1, x2, y2, rek - 1);
			kochKurve(x2, y2, x3, y3, rek - 1);
			kochKurve(x3, y3, bx, by, rek - 1);

		}
	}

	public static void main(String[] args) {
		kochKurve(0, 500, 500, 500, 2);
		System.out.printf("(" + "%.1f" + "/" + "%.1f" + ")", 500.0, 500.0);

	}

}
