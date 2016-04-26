package docanalysis;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;


public class SimpleTokenizer {

	/**
	 * Diese Methode liest eine Datei ein und gibt die Liste der
	 * Tokens, die sie enthält, zurück. Dabei handelt es sich um
	 * sämtliche Wörter, Zahlen und Punktuationszeichen, die durch
	 * Leerzeichen oder Zeilenumbrüche voneinander getrennt sind.
	 * 
	 * @param file Die zu lesende Datei
	 * @param encoding Das korrekte Encoding, z.B. UTF-8
	 * @return
	 * @throws IOException
	 */
	public static List<String> getTokens(File file, String encoding) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
		StringBuffer sb = new StringBuffer();
		String line;
		while((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		br.close();
		BreakIterator iterator = BreakIterator.getWordInstance();
		String text = sb.toString();
		iterator.setText(text);
		List<String> words = new ArrayList<String>();
		int last = 0;
		while(true) {
			int next = iterator.next();
			if(next == -1) break;
			String sub = text.substring(last, next).trim();
			if(sub.length() == 0) continue;
			words.add(sub);
			last = next;
		}
		return words;
	}
	
}
