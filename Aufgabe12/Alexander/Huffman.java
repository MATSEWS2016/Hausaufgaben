import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Dekodiert eine Hufmann verschluesselte Datei. Diese muss in Binaer verfasst sein. 
 * Dabei repraesentieren die Zeilen 2-27 die Buchstaben A-Z.
 * Die Zeile 28 repraesentiert das Leerzeichen.
 * Die Zeile 1 repraesentiert den verschluesselten Text.
 * @author Alexander
 *
 */
public class Huffman {
	public static String decode(File f) {
		//speichert die Zuordnung Binaer -> Zeichen
		Map<String, Character> alphabet = new HashMap<>();

		String text = "";
		int lineCount = -1;
		//Einlesen der Datei
		try (Scanner scanner = new Scanner(f)) {
			while (scanner.hasNext()&&lineCount<28){
				String line = scanner.nextLine();
				if(lineCount == -1){
					text = line;
				}else if(!line.equals("")){
					//0-25 wandle in Buchstaben
					//26 wandle in Leerzeichen
					char c = (char) (lineCount<26?65+lineCount:32);
					alphabet.put(line, c);
				}
				lineCount++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(lineCount<27){
			throw new IllegalArgumentException("Invalid number of lines. 28 expected.");
		}

		return decode(text,alphabet);
	}
	
	
	/**
	 * Rekursive Funktion. Iteriert ueber "text" um einen Key von "alphabet" zu finden.
	 * Der Rest des "text" Strings wird erneut an die Funktion uebergeben.
	 * @param text der Text, in dem nach dem vorkommen eines Keys gesucht wird.
	 * @param alphabet das Alphabet zum uebesetzen des Keys.
	 * @return den Wert des Keys plus den Rueckgabewert des rekursiven Aufrufes. 
	 */
	private static String decode(String text, Map<String,Character> alphabet){
		String key = "";
		while(!alphabet.containsKey(key) && text.length()>0){
			key+=text.charAt(0);
			text = text.substring(1);
		}
		
		if(text.length() == 0){
			return alphabet.get(key).toString();
		}
		
		return alphabet.get(key) + decode(text,alphabet);
	}
}
