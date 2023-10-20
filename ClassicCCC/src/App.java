import java.util.*;
import java.io.*;
public class App {

    public static boolean example = false;
    public static int level = 2;
    public static void main(String[]args) throws Exception {
        File level = new File("level2");
        File[] testfiles = level.listFiles();

        for (File f : testfiles){
            if(f.getAbsolutePath().contains(".out")) continue;
            if(example && !f.getAbsolutePath().contains("example")) continue;
            if(!f.getAbsolutePath().contains("2_1")) continue;

            Scanner s = new Scanner(f);
            List<List<Character>> field = new ArrayList<>();

            int length = s.nextInt();

            s.nextLine();
            for(int i = 0; i < length; i++) {
                String line = s.nextLine();
                List<Character> row = new ArrayList<>();
                for(int j = 0; j < line.length(); j++) {
                    row.add(line.charAt(j));
                }
                field.add(row);
            }


            Field fieldO = new Field(field);
            int numOfCoordiantes = s.nextInt();
            s.nextLine();
            try (BufferedWriter outfile = new BufferedWriter(new FileWriter(f.getAbsolutePath().replace(".in", ".out")))) {
                for(int i = 0; i < numOfCoordiantes; i++) {
                    String[] coordinates = s.nextLine().split(" ");
                    String[] a = coordinates[0].split(",");
                    String[] b = coordinates[1].split(",");
                    Coordinate ac = new Coordinate(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
                    Coordinate bc = new Coordinate(Integer.parseInt(b[0]), Integer.parseInt(b[1]));

                    if(fieldO.isOnSame(ac, bc)) {
                        outfile.write("SAME\n");
                    } else {
                        outfile.write("DIFFERENT\n");
                    }
                }
            }
        }
    }

}
