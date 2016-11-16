/**
 * Implementation des {@link Rechenoperation} Interfaces. Fuehrt eine Addition mit einem, im Konstruktor definiertenWert, aus.
 * @author Alexander
 *
 */
public class Addition implements Rechenoperation{

	private int number;
	
	/**
	 * Konstruktor
	 * @param number mit diesem Wert wird in der berechne Methode addiert.
	 */
	public Addition(int number){
		this.number = number;
	}

	/**
	 * Addiert den Wert, welcher in numb er gespeichert ist zu dem uebergebenem double dazu.
	 */
	@Override
	public double berechne(double x) {
		return x + number;
	}

}
