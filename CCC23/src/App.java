import java.io.*;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        File level = new File("level1");
        assert level != null;
        File[] testfiles = level.listFiles();
        for(File f : testfiles) {

        }
    }

}
