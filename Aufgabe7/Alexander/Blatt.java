import java.util.Arrays;

public class Blatt {
	
	private int[]  cards;
	
	public Blatt(int [] cards){
		if(cards.length == 3){
			this.cards = new int[3];
			System.arraycopy(cards, 0, this.cards, 0, 3);
		}else{
			throw new ArithmeticException("Invalid field length of parameter.");
		}
	}
	
	public String toString(){
		String retval = Arrays.toString(cards);
		return retval.replaceAll("\\[", "").replaceAll("\\]", "");
	}
	
	public int[] getCards(){
		return cards;
	}

}
