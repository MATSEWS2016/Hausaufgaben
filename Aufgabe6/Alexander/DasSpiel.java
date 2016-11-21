/**
 * Testklasse
 * @author Alexander
 *
 */
public class DasSpiel {
	
	public static void main(String[] args) {
		GefDilemma gf = new GefDilemma(new Random(), new PerKind());
		gf.spiele(100);
	}

}
