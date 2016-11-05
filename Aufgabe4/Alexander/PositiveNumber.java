/**
 * Die {@link PositiveNumber} Klasse kann (wenn zusaetzliche setter und getter
 * ergaenzt werden) mit allen Zahlensystemen zwischen dem 2er und dem 35er
 * umgehen.
 * 
 * @author Alexander Brennecke
 *
 */
public class PositiveNumber {

	// speichert den Wert als Dezimal Zahl
	private int value;

	/**
	 * Setzt den value auf den Wert des uebrgebenen Strings.
	 * 
	 * @param s
	 *            die Zahl in einem beliebigem Zahlensystem
	 * @param system
	 *            das Zahlensystem (2-35)
	 */
	private void setValue(String s, int system) {
		if (system < 2 || system > 35) {
			throw new NumberFormatException("Unsuported number system. Use 2 to 35!");
		}

		s = s.toUpperCase();
		value = getDecimal(s, system);
	}

	/**
	 * Konvertiert einen Dezimalwert in das uebergebene Zahlensystem
	 * 
	 * @param decimal
	 *            eine Zahl im Dezimalsystem
	 * @param aimSystem
	 *            das System, in das Konvertiert werden soll (2-35)
	 * @return die umgewandelte Zahl als String
	 */
	private String convert(int decimal, int aimSystem) {
		String retval = "";
		while (decimal != 0) {
			int value = decimal % aimSystem;
			decimal = decimal / aimSystem;
			retval = getCharacter(value) + retval;
		}
		return retval;
	}

	/**
	 * Rechnet den uebergebenen Zahlenwert in einen Character um
	 * 
	 * @param value
	 *            der umzurechnende Zahlenwert
	 * @return den Zahlenwert als Character (0-9A-Z)
	 */
	private String getCharacter(int value) {
		int retval = 0;
		if (value < 10) {
			retval = 48 + value;
		} else if (retval <= 35) {
			retval = 65 + value - 10;
		}
		return String.valueOf(((char) retval));
	}

	/**
	 * Rechnet den uebergebenen String in das Dezimalsystem um.
	 * 
	 * @param s
	 *            die Zahl, die umgerechnet werden soll.
	 * @param startSystem
	 *            das Zahlensystem der Zahl
	 * @return
	 */
	private int getDecimal(String s, int startSystem) {
		int value = 0;
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i);
			num = valueOfChar(num, startSystem);
			num *= (int) Math.pow(startSystem, s.length() - 1 - i);
			if (num > Integer.MAX_VALUE - value) {
				throw new ArithmeticException("Number to big");
			}
			value += num;
		}
		return value;
	}

	/**
	 * Berechnet den Wert des uebergebenen Characters im Zahlensystem
	 * 
	 * @param c
	 *            eine Stelle der Zahl als ASCII Wert
	 * @param startSystem
	 *            Zahlensystem der Zahl (2-35)
	 * @return den Wert des Characters (0 bis startSystem-1)
	 */
	private int valueOfChar(int c, int startSystem) {
		int retval = 0;
		if (c > 47 && c < 58) {
			retval = c - 48;
		} else if (c > 64 && c < 91) {
			retval = c - 55;
		} else {
			throw new NumberFormatException("Unsuported character.");
		}

		if (retval >= startSystem) {
			throw new NumberFormatException(
					((char) c) + " is not a valid Character in the " + startSystem + " system!");
		}

		return retval;
	}

	/**
	 * Setzt den uebergebenen String als Dezimalzahl in das value-Attribut
	 * 
	 * @param s
	 *            die Zahl im Dezimalsystem
	 */
	public void setDecimal(String s) {
		setValue(s, 10);
	}

	/**
	 * Setzt den uebergebenen String als Dezimalzahl in das value-Attribut
	 * 
	 * @param s
	 *            die Zahl im Hexadezimalsystem
	 */
	public void setHexadecimal(String s) {
		setValue(s, 16);
	}

	/**
	 * Setzt den uebergebenen String als Dezimalzahl in das value-Attribut
	 * 
	 * @param s
	 *            die Zahl im Binaersystem
	 */
	public void setBinary(String s) {
		setValue(s, 2);
	}

	/**
	 * @return das value-Attribut als Dezimalzahl
	 */
	public String getDecimal() {
		return String.valueOf(value);
	}

	/**
	 * Rechnet das value-Attribut in eine Hexadezimalzahl um.
	 * 
	 * @return das value-Attribut als Hexadezimalzahl
	 */
	public String getHexadecimal() {
		return convert(value, 16);
	}

	/**
	 * Rechnet das value-Attribut in eine Binaerzahl um.
	 * 
	 * @return das value-Attribut als Binaerzahl
	 */
	public String getBinary() {
		return convert(value, 2);
	}

	/**
	 * Main zum testen diverser Eingaben
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PositiveNumber zs = new PositiveNumber();
		zs.setDecimal("144");
		System.out.println("Binaer: " + zs.getBinary());
		zs.setHexadecimal("affe");
		System.out.println("Dezimal: " + zs.getDecimal());
		zs.setBinary("1000101011");
		System.out.println("Hexadezimal: " + zs.getHexadecimal());
		try {
			zs.setHexadecimal("G");
		} catch (NumberFormatException nfe) {
			System.out.println("G"+" kann nicht als Hexzahl gesetzt werden");
		}
		
		try {
			zs.setHexadecimal("-A2");
		} catch (NumberFormatException nfe) {
			System.out.println("-A2 ist negativ und kann daher nicht gesetzt werden");
		}
		
		try {
			zs.setHexadecimal("FFFFFFFFFFFFFFF");
		} catch (ArithmeticException ae) {
			System.out.println("FFFFFFFFFFFFFFF ist groesser als INT.MAX_VALUE und kann daher nicht gesetzt werden");
		}
	}

}
