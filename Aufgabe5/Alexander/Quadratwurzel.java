/**
 * Implementation des {@link Rechenoperation} Interfaces. 
 * Berechnet die zweite Wurzel der uebergebenen Zahl.
 * @author Alexander
 *
 */
public class Quadratwurzel implements Rechenoperation{

	/**
	 * Berechnet die zweite Wurzel der uebergebenen Zahl.
	 * @throws ArithmeticException, wenn x negativ ist.
	 */
	@Override
	public double berechne(double x) {
		if(x<0){
			throw new ArithmeticException();
		}
		return Math.sqrt(x);
	}

}
