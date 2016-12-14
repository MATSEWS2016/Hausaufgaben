public class ZahlwortEnglisch extends Zahlwort {

	final String[] ZAHLEN = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve","thirteen","fourteen","fiveteen","sixteen","seventeen","eightteen","nineteen"};
	final String[] ZEHNER = { "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	public ZahlwortEnglisch(int x) {
		super(x);
	}

	public String getWortString() {
		String retval = "";
		int[] splitted = splitNum();
		
		if(splitted[3] != 0){
				retval += ZAHLEN[splitted[3]-1] + " thousand ";
		}
		
		if(splitted[2] != 0){
			retval += ZAHLEN[splitted[2]-1] + " hundert ";
		}
		
		if(!retval.equals("")&&(splitted[0]!=0||splitted[1]!=0)){
			retval += "and ";
		}
		
		if(splitted[1] >=2){
			retval+=  ZEHNER[splitted[1]-2];
			if(splitted[0] != 0){
				retval+="-"+ZAHLEN[splitted[0]-1];
			}
		}else{
			retval+= ZAHLEN[x%100-1];
		}
		
		return retval;
	}

	public String getSprache() {
		return "deutsch";
	}
}