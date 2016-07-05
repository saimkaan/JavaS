import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by saim on 28/06/16.
 */
public class Search extends Thread {

    String name;

    public Search(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run(){
        try {
            showDirectory();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void showDirectory() throws InterruptedException{
        String directoryName = "/Users/saim/Downloads/";
        ArrayList<File> files = getPaths(new File(directoryName),
                new ArrayList<File>());
        if(files == null) return;
        try {
            for (int i = 0; i < files.size(); i++)
                System.out.println(files.get(i).getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep((long) (1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static ArrayList<File> getPaths(File file, ArrayList<File> list) {
        if (file == null || list == null || !file.isDirectory())
            return null;
        File[] fileArr = file.listFiles();
        for (File f : fileArr) {
            if (f.isDirectory()) {
                getPaths(f, list);
            }
            list.add(f);
        }
        return list;
    }
}
