import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class App {

    public static boolean example = false;
    public static int level = 4;
    public static void main(String[]args) throws Exception {
        File level = new File("level4");
        File[] testfiles = level.listFiles();

        for (File f : testfiles){
            if(f.getAbsolutePath().contains(".out")) continue;
            if(example && !f.getAbsolutePath().contains("example")) continue;
            //if(!f.getAbsolutePath().contains("2_1")) continue;

            Scanner s = new Scanner(f);
            List<List<Character>> fieldList = new ArrayList<>();

            int length = s.nextInt();

            s.nextLine();
            for(int i = 0; i < length; i++) {
                String line = s.nextLine();
                List<Character> row = new ArrayList<>();
                for(int j = 0; j < line.length(); j++) {
                    row.add(line.charAt(j));
                }
                fieldList.add(row);
            }


            Field field = new Field(fieldList);
            int numOfRoutes = s.nextInt();
            s.nextLine();
            try (BufferedWriter outfile = new BufferedWriter(new FileWriter(f.getAbsolutePath().replace(".in", ".out")))) {
                for (int i = 0; i < numOfRoutes; i++) {
                    String[] coordinates = s.nextLine().split(" ");
                    Coordinate start = new Coordinate(Integer.parseInt(coordinates[0].split(",")[0]), Integer.parseInt(coordinates[0].split(",")[1]));
                    Coordinate end = new Coordinate(Integer.parseInt(coordinates[1].split(",")[0]), Integer.parseInt(coordinates[1].split(",")[1]));
                    List<Coordinate> path = field.findPath(start, end);
                    if (path != null) {
                        outfile.write(String.join(" ", path.stream().map(Coordinate::toString).collect(Collectors.toList())) + "\n");
                    } else {
                        outfile.write("NO VALID ROUTE\n");
                    }
                }
            }


        }
    }

}
