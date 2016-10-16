/**
 * GoldTagespreis ist eine Modell-Klasse. Sie repraesentiert die Zuordnung eines
 * Datums zu einem Preis.
 * 
 * @author Alexander Brennecke
 *
 */
public class GoldTagespreis {

	// / ATTRIBUTE///
	// Platzhalter, falls kein Preis definiert war
	private static final String NO_PRICE = "kein Nachweis";

	private String datum;
	private double preis;

	// /KONSTRUKTOREN///
	/**
	 * Wandelt die Übergabeparameter und speichert sie in Attributen.
	 * @param datum das Datum des Preises
	 * @param preis der Preis in der Form 12.345,67
	 */
	public GoldTagespreis(String datum, String preis) {
		this.datum = datum;
		//Ersetze Punkt durch nichts und Kommatar durch Punkt für die Umwandlung in einen Double
		String castedPreis = preis.replaceAll("\\.", "").replaceAll(",", "\\.");
		this.preis = castedPreis.equals(NO_PRICE) ? -1.0 : Double.valueOf(castedPreis);
	}

	// /METHODEN///
	/**
	 * @return das gesetzte Datum
	 */
	public String getDatum() {
		return datum;
	}

	/**
	 * 
	 * @return den gesetzten Preis
	 */
	public double getPreis() {
		return this.preis;
	}

	/**
	 * @return Den Preis und das Datum in einem ansprechenden Format.
	 */
	public String toString() {
		return "Datum: " + datum + "  Preis:" + preis;
	}

	
	/**
	 * Vergleicht diesen Preis mit dem übergebenen.
	 * @param com der zu vergleichende Preis
	 * @param bigger true = größer, false = kleiner
	 * @return den größeren oder kleineren {@link GoldTagespreis}
	 */
	public GoldTagespreis compare(GoldTagespreis com, boolean bigger) {
		double myPrice = Double.valueOf(getPreis());
		double hisPrice = Double.valueOf(com.getPreis());
		if (hisPrice == -1) {
			return this;
		}

		GoldTagespreis retval;
		if (bigger) {
			retval = myPrice > hisPrice ? this : com;
		} else {
			retval = myPrice < hisPrice ? this : com;
		}

		return retval;
	}
}
