/**
 * Implementation des {@link Rechenoperation} Interfaces. Berechnet die Potenz mir 2.
 * @author Alexander
 *
 */
public class Quadrat implements Rechenoperation{

	/**
	 * Quadriert den uebergebenen Wert.
	 */
	@Override
	public double berechne(double x) {
		return Math.pow(x,2);
	}

	
}
