import java.util.*;
import java.io.*;
public class App {

    public static boolean example = false;

    public static void main(String[]args) throws Exception {
        File level = new File("level1");
        File[] testfiles = level.listFiles();

        for (File f : testfiles){
            if(f.getAbsolutePath().contains(".out")) continue;
            if(example && !f.getAbsolutePath().contains("example")) continue;

            Scanner s = new Scanner(f);

            try (BufferedWriter outfile = new BufferedWriter(new FileWriter(f.getAbsolutePath().replace(".in", ".out")))) {

            }
        }
    }
}
