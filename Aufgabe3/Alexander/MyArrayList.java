import java.util.Arrays;

/**
 * Klasse, welche ein int Array wie eine ArrayList verwaltet.
 * 
 * @author Alexander Brennecke
 *
 */
public class MyArrayList {

	// Klassenattribute
	private int[] arr = new int[10];
	private int size = 0;

	/**
	 * Fuegt am Ende des Arrays den uebergebenen Wert ein und ueberprueft die
	 * Arraygroesse ueber die enlargeList() Funktion.
	 * 
	 * @param i
	 *            der Wert, der angefuegt wird
	 */
	public void add(int i) {
		enlargeList();
		arr[size] = i;
		size++;
	}

	/**
	 * Fuegt einen Wert an der gegebenen Position ein. nd ueberprueft die
	 * Arraygroesse ueber die enlargeList() Funktion.
	 * 
	 * @param i
	 *            der Wert, der eingefuegt werden soll
	 * @param pos
	 *            die Position, an der dieser eingefuegt werden soll
	 */
	public void add(int i, int pos) {
		enlargeList();

		// Ueberpruefung der Position
		if (pos < 0 || pos >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}

		int[] temp = new int[arr.length];

		// Elemente vor und hinter der Position werden aus der aktuellen Liste
		// uebernommen
		System.arraycopy(arr, 0, temp, 0, pos);
		temp[pos] = i;
		System.arraycopy(arr, pos, temp, pos + 1, arr.length - pos - 1);

		// speichern des temoraeren Arrays in das Klassenattribut und erhoehung
		// der Groesse
		temp[pos] = i;
		arr = temp;
		size++;
	}

	/**
	 * Iterriert ueber das aktuelle Array und fuegt jedes Element einem neuen
	 * {@link MyArrayList} Objekt hinzu. Nicht die performanteste Loesung,
	 * dadurch werden jedoch einige zusaetzliche Getter und Setter Methoden
	 * vermieden.
	 */
	public MyArrayList clone() {
		MyArrayList retval = new MyArrayList();
		for (int i = 0; i < size; i++) {
			retval.add(arr[i]);
		}
		return retval;
	}

	/**
	 * Loescht den Wert an der gegebenen Stelle. Alle dahinter stehenden Werte werden um einen nach Vorne/Links geschoben.
	 * @param pos die Position des zu loeschenden Wertes.
	 */
	private void delete(int pos) {
		
		//Ueberpruegung der Position
		if (pos < 0 || pos >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		//Erstellung des neuen Arrays und kopieren der alten Elemente
		int[] temp = new int[arr.length];
		System.arraycopy(arr, 0, temp, 0, pos);
		System.arraycopy(arr, pos + 1, temp, pos, arr.length - pos - 1);
		
		//Speichern des neuen Arrays im Klassenattribut
		arr = temp;
		size--;
		reduceList();
	}
	
	/**
	 *  Verdoppelt die Groesse des Arrays, wenn alle Elemente des aktuellen Arrays belegt sind.
	 */
	private void enlargeList() {
		if (size >= arr.length) {
			int[] temp = new int[size * 2];
			System.arraycopy(arr, 0, temp, 0, size);
			arr = temp;
		}

	}
	
	/**
	 * Ueberprueft die Anzahl der verwendeten Elemente in der Liste. 
	 * Wenn diese kleiner als ein Drittel aller Elemente ist, wird die Liste halbiert.
	 */
	private void reduceList() {
		if (size <= (arr.length + 2) / 3) {
			int newSize = (int) (arr.length) / 2;
			int[] temp = new int[newSize];
			System.arraycopy(arr, 0, temp, 0, newSize);
			arr = temp;
		}

	}
	
	/**
	 * Setzt das Array auf ein leeres Array der Groesse 10 zurueck.
	 */
	public void clear() {
		arr = new int[10];
		size = 0;
	}

	/**
	 * Greift auf das Array an der gegebenen Position zu.
	 * 
	 * @param pos
	 *            die Position des Wertes
	 * @return der Wert im Array.
	 */
	public int get(int pos) {
		return arr[pos];
	}

	/**
	 * Gibt die Menge der gesetzten Elemente des Arrays zurueck.
	 * 
	 * @return die Menge der gesetzten Elemente-
	 */
	public int size() {
		return size;
	}

	/**
	 * Gibt die Groesse des Arrays inkl. leerer Elemente an.
	 * 
	 * @return die Groese des Arrays
	 */
	public int capacity() {
		return arr.length;
	}

	
	/**
	 * Erstellt ein temporaeres Array mit den Elemente von Null bis zur
	 * aktuellen Groese. Aus diesem wird mittels Arrays.toString() ein String
	 * definiert und zurueck gegeben.
	 */
	public String toString() {
		int[] temp = new int[size];
		System.arraycopy(arr, 0, temp, 0, size);
		return Arrays.toString(temp);
	}

// Wusste nicht, ob die notwendig ist, oder eventuell stoert, deswegen habe ich sie mal auskommentiert.
//	public static void main(String[] args) {
//		MyArrayList al = new MyArrayList();
//		for (int i = 0; i < 10; i++) {
//			al.add(i);
//		}
//
//		System.out.println(al);
//		System.out.println(al.size());
//
//		al.add(5, 2);
//		System.out.println(al);
//
//		for (int i = 6; i > 0; i--) {
//			al.delete(i);
//			System.out.println(al.capacity() + "/" + al.size);
//		}
//		System.out.println(al);
//		System.out.println(al.get(2));
//
//		MyArrayList al2 = al.clone();
//		al.clear();
//		System.out.println(al);
//		System.out.println(al2);
//	}
}
