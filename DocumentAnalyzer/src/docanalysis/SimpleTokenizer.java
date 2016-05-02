package docanalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Die Helfer-Klasse docanalysis.SimpleTokenizer konvertiert Wörter einer Datei
 * zu einer String-Liste.
 * 
 * @author Mihail Atanassov
 */
public class SimpleTokenizer {

	/**
	 * Diese Methode liest eine Datei ein und gibt die Liste der Tokens, die sie
	 * enthält, zurück.
	 * 
	 * @param file
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static List<String> getTokens(File file, String encoding)
			throws IOException {

		String text = getText(file, encoding);

		/*
		 * • Der java.text.BreakIterator ermittelt ver. Grenzen (s.g.
		 * "Boundaries") auf unterschiedlichen Ebenen innerhalb einer textuellen
		 * Eingabe:
		 * 
		 * o ZEICHEN (BreakIterator.getCharacterInstance()) o WORT
		 * (BreakIterator.getWordInstance()) o SATZ
		 * (BreakIterator.getSentenceInstance() o ZEILE
		 * (BreakIterator.getLineInstance())
		 * 
		 * • Die BreakIterator-Klasse ist "locale-sensitive". Ein
		 * java.util.Locale Objekt repräsentiert eine best. geographische,
		 * politische oder kulturelle Region. Ein Objekt, oder eine Methode,
		 * welches/welche ein Locale benötigt, um eine Berechnung durchzuführen,
		 * nennt man auch "locale-sensitive". Bspw. ist das Anzeigen (bspw.
		 * mittels System.out.println(...)) von Zahlen eine "locale-sensitive"
		 * Operation, denn die darzustellende Zahl sollte nach den Regeln und
		 * Konventionen der Heimat, Region oder Kultur der/des jeweiligen
		 * BenutzerIn sein.
		 * 
		 * • Ein BreakIterator hat einen imaginären Cursor, der auf die
		 * aktuellen "Bounderies" eines Eingabetextes verweist. Der Cursor wird
		 * durch die Methoden previous() und next() bewegt. Der Cursor bewegt
		 * sich mit jedem Aufruf von next() zur nächsten "Wort-Boundery". Der
		 * Rückgabewert der Methode next() repräsentiert die Position des
		 * Cursors, wobei die Position den Index des Zeichens aus dem (gesamten)
		 * Text darstellt, welches unmittelbar die "Boundery" folgt. Äquivalent
		 * zum String-Index, ist auch der "Boundery-Index" null-basiert, d.h.
		 * die erste "Boundery" befindet sich an Position 0 und die letzte an
		 * String.length des Eingabetextes.
		 * 
		 * • Die Klasse BreakIterator sollte nur zur Tokenisierung
		 * natürlich-sprachlicher Texte benutzt werden.
		 */

		// Wir holen eine Instanz eines BreakIterators, der auf Wortebene den
		// Eingabetext "text" tokenisiert und setzen den spreachlichen Kontext.
		BreakIterator iterator = BreakIterator.getWordInstance(Locale.GERMAN);
		iterator.setText(text); // Wir setzen den zu scannenden Text
		int start = iterator.first();
		int end = iterator.next();

		List<String> words = new ArrayList<String>();
		while (end != BreakIterator.DONE) {
			String subStringFromText = text.substring(start, end);
			if (Character.isLetterOrDigit(subStringFromText.charAt(0))
					&& subStringFromText.length() > 1) {
				words.add(subStringFromText);
			}
			start = end;
			end = iterator.next();
		}
		return words;
	}

	private static String getText(File file, String encoding)
			throws UnsupportedEncodingException, FileNotFoundException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), encoding));
		StringBuffer stringBuffer = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) {
			stringBuffer.append(line).append(System.lineSeparator());
		}
		br.close();
		return stringBuffer.toString();
	}

}
