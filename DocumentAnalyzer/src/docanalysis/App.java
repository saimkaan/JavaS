package docanalysis;

import java.io.File;
import java.text.BreakIterator;

/**
 * Created by saim on 02/05/16.
 */
public class App {
    static void Ausgabe( String s, BreakIterator iter )
    {
        iter.setText( s );

        for ( int last = iter.first(),next = iter.next();
              next != BreakIterator.DONE;
              last = next, next = iter.next() )
        {
            CharSequence part = s.subSequence( last, next );

            if ( Character.isLetterOrDigit( part.charAt( 0 ) ) )
                System.out.println( part );
        }
    }

    public static void main(String[] args) {

//        File input =  new File("DocumentAnalyzer/documents/Hashfunktion.txt");

        
        String Txt1 = "Als Binärbaum bezeichnet man in der Graphentheorie eine spezielle Form eines Graphen. Genauer gesagt handelt es sich um einen Wurzelbaum (gewurzelten Baum), bei dem jeder Knoten höchstens zwei Kindknoten besitzt. Meist wird verlangt, dass sich die Kindknoten eindeutig in linkes und rechtes Kind einteilen lassen. Ein anschauliches Beispiel für einen solchen Binärbaum ist die Ahnentafel. Hierbei sind allerdings die Elternteile die Kindknoten.\n",
                Txt2 = "Eine Hashfunktion oder Streuwertfunktion ist eine Abbildung, die zu jeder Eingabe aus einer oft sehr großen Quellmenge eine Ausgabe aus einer kleineren Zielmenge erzeugt, den sogenannten Hashcode (oder Hashwert).\n";

        BreakIterator WordInstance = BreakIterator.getWordInstance();
        BreakIterator SentenceInstance = BreakIterator.getSentenceInstance();
        BreakIterator LineInstance = BreakIterator.getLineInstance();

//        SimpleTokenizer.getTokens(input, );   Ich komme nicht auf den richtigen Ansatz


        System.out.println("------WordInstance------");

        Ausgabe(Txt1, WordInstance);
        Ausgabe(Txt2, WordInstance);

        System.out.println("------SentenceInstance------");

        Ausgabe(Txt1, SentenceInstance);
        Ausgabe(Txt2, SentenceInstance);

        System.out.println("------LineInstance------");

        Ausgabe(Txt1, LineInstance);
        Ausgabe(Txt2, LineInstance);

    }


}
