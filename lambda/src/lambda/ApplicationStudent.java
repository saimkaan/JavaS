package lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by saim on 20/06/16.
 */
public class ApplicationStudent {
    public static void main(String[] args) {
        new ApplicationStudent();
    }

    public ApplicationStudent(){
        File file = new File("/Users/saim");

        // 1) Klassisch
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        // 2) lambda-Style
        FileFilter filter = (File f) -> { return f.isFile(); };
        File[] listFiles = file.listFiles(filter);

        // 3) lambda-Style
        file.listFiles((File f) -> { return f.isFile(); });

        // 4) lambda-Style
        file.listFiles(f -> f.isFile());

        // 5) lambda-Style
        file.listFiles(File::isFile);

        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        c = (String s1, String s2) -> s1.compareTo(s2);

        c = (s1, s2) -> s1.compareTo(s2);

        Collections.sort(null, (String s1, String s2) -> s1.compareTo(s2));

        for (File f : files
             ) {
            System.out.println(f.getName());
        }
    }
}
