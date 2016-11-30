
public class WrongNumberException extends RuntimeException {

	public WrongNumberException(){
		super("i liegt nicht zwischen 1 und 15");
	}

	public static void check(int i){
		if(i<1||i>15){
			throw new WrongNumberException();
		}
	}
}
