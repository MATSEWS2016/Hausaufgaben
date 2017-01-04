import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class Test {
	public static void main(String[] args) throws URISyntaxException {
		URL url = Test.class.getClassLoader().getResource("message.txt");
		File f = new File(url.toURI());
		System.out.println(Huffman.decode(f));
	}
}
