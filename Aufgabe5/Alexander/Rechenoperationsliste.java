import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Der Rechenoperationsliste koennen {@link Rechenoperation} Objekte hinzugefuegt werden.
 * Diese werden mithilfe der Methode transform, nacheinander ausgefuehrt.
 * @author Alexander
 *
 */
public class Rechenoperationsliste {
	
	List<Rechenoperation> operations;
	
	/**
	 * Konstruktor, welcher die {@link Rechenoperation} ArrayListe initialisiert.
	 */
	public Rechenoperationsliste(){
		operations = new ArrayList<>();
	}
	
	/**
	 * Fuegt eine Rechenoperation am Ende der Liste ein.
	 * @param operation Die Rechenoperation, die eingefuegt werden soll.
	 */
	public void add(Rechenoperation operation){
		operations.add(operation);
	}
	
	/**
	 * Ruft die berechne Methode aller {@link Rechenoperation}en auf, die bereits hinzugefuegt wurden.
	 * @param feld alle Rechenoperationen werden fuer jedes Element im Feld aufgerufen
	 * @return ein neues Feld, welches von der groesse identisch mit dem Ausgangsfeld ist, und die berechneten Werte enthaelt.
	 */
	public double[] transform(double[] feld){
		double[] retval = new double[feld.length];
		for(int i = 0; i<feld.length;i++){
			double temp = feld[i];
			for(Rechenoperation operation : operations){
				temp = operation.berechne(temp);
			}
			retval[i] = temp;
		}
		return retval;
	}
	
	
	/**
	 * Main zum testen des Programmes
	 * @param args
	 */
	public static void  main(String[] args){
		double[] ausgangsfeld = {1,3,5,6};
		Rechenoperationsliste r = new Rechenoperationsliste();
		
		r.add(new Quadrat());
		r.add(new Addition(2));
		
		double[] test1 = r.transform(ausgangsfeld);
		System.out.println(Arrays.toString(test1));
		
		r.add(new Quadratwurzel());
		double[] test2 = r.transform(ausgangsfeld);
		System.out.println(Arrays.toString(test2));
	}

}
