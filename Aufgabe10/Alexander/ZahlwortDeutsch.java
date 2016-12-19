/**
 * Erzeugt das ausgeschriebene Wort einer Zahl auf Deutsch
 * @author Alexander Brennecke
 *
 */
public class ZahlwortDeutsch extends Zahlwort {

	private final String[] ZAHLEN = { "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwoelf","dreizehn","vierzehn","fuenfzehn","sechzehn","siebzehn","achtzehn","neunzehn"};
	private final String[] ZEHNER = { "zwanzig", "dreissig", "vierzig", "fuenfizg", "sechzig", "siebzig", "achtzig", "neunzig" };

	/**
	 * Konstruktor, ruft super Konstruktor auf
	 * @param x die Zahl zwischen 1 und 9999
	 */
	public ZahlwortDeutsch(int x) {
		super(x);
	}

	@Override
	public String getWortString() {
		String retval = "";
		int[] splitted = splitNum();
		
		if(x == 1){
			return "eins";
		}
		
		if(splitted[3] != 0){
				retval += ZAHLEN[splitted[3]-1] + "tausend";
		}
		
		if(splitted[2] != 0){
			retval += ZAHLEN[splitted[2]-1] + "hundert";
		}
		
		if(splitted[1] >=2){
			if(splitted[0] != 0){
				retval+=ZAHLEN[splitted[0]-1]+"und";
			}
			retval+= ZEHNER[splitted[1]-2];
		}else if(splitted[0] != 0 && splitted[1]!=0){
			String s = ZAHLEN[x%100-1];
			retval = retval +s;
		}
		
		return retval;
	}

	@Override
	public String getSprache() {
		return "deutsch";
	}
}