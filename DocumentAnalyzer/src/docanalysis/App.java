package docanalysis;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by saim on 02/05/16.
 */
public class App {
    public static void main(String[] args) throws IOException {
        File file1 = new File("DocumentAnalyzer/documents/Hashfunktion.txt");
        File file2 = new File("DocumentAnalyzer/documents/Binärbaum.txt");
        File stopF = new File("DocumentAnalyzer/StopWords.txt");

        Set<String> mySet1 = new HashSet<String>(SimpleTokenizer.getTokens(file1, "UTF-8"));
        Set<String> mySet2 = new HashSet<String>(SimpleTokenizer.getTokens(file2, "UTF-8"));

        Set<String> myStop = new HashSet<String>(SimpleTokenizer.getTokens(stopF, "UTF-8"));


        System.out.println(mySet1);
        System.out.println(mySet1.size());
        System.out.println(myStop);
        System.out.println("----------------------");
        System.out.println(mySet1.removeAll(myStop));
        System.out.println(mySet1);
        System.out.println(mySet1.size());

        System.out.println("----------------------");

        System.out.println(mySet2);
        System.out.println(mySet2.size());
        System.out.println(myStop);
        System.out.println("----------------------");
        System.out.println(mySet2.removeAll(myStop));
        System.out.println(mySet2);
        System.out.println(mySet2.size());

    }


}
