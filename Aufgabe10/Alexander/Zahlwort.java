
public abstract class Zahlwort {
	protected int x;
	
	public Zahlwort(int x) {
		if (x<=0 || x>=10000) {
			throw new NumberFormatException("Zahl "+x+" nicht im "+
			" Bereich zwischen 1 und 9999");
		} else {
			this.x = x;
		}
	}
	
	public String getZifferString() {
		return x+"";
	}
	
	/**
	 * Wandelt die Zahl in ein ausgeschriebenes Wort
	 * @return die umgewandelte Zahl als String
	 */
	public abstract String getWortString();
	
	/**
	 * @return den Namen der Sprache.
	 */
	public abstract String getSprache();
	
	public String toString() {
		return "Die Zahl "+x+" schreibt man auf " + getSprache() + ": "+getWortString()+".";
	}
	
	/**
	 * Splitted die Zahl in ein int[] der groese 4.
	 * @return Das erzeugt int[]
	 */
	protected int[] splitNum(){
		int[] retval = new int[4];
		int num  = x;
		for( int i =0; i<4;i++){
			retval[i] = num % 10;
			num = num / 10;
		}
		
		return retval;
	}
}