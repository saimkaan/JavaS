/**
 * Created by saim on 27/06/16.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
            new Search("1").start();
    }

//    public static void main(String[] args) {
//        String directoryName = "/Users/saim/Downloads/";
//        ArrayList<File> files = getPaths(new File(directoryName),
//                new ArrayList<File>());
//        if(files == null) return;
//        try {
//            for (int i = 0; i < files.size(); i++)
//                System.out.println(files.get(i).getCanonicalPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static ArrayList<File> getPaths(File file, ArrayList<File> list) {
//        if (file == null || list == null || !file.isDirectory())
//            return null;
//        File[] fileArr = file.listFiles();
//        for (File f : fileArr) {
//            if (f.isDirectory()) {
//                getPaths(f, list);
//            }
//            list.add(f);
//        }
//        return list;
//    }
}
