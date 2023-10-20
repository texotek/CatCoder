import java.util.*;
import java.io.*;
public class App {

    public static boolean example = false;
    public static int level = 3;
    public static void main(String[]args) throws Exception {
        File level = new File("level3");
        File[] testfiles = level.listFiles();

        for (File f : testfiles){
            if(f.getAbsolutePath().contains(".out")) continue;
            if(example && !f.getAbsolutePath().contains("example")) continue;
            //if(!f.getAbsolutePath().contains("2_1")) continue;

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
            // ...
            int numOfRoutes = s.nextInt();
            s.nextLine();
            try (BufferedWriter outfile = new BufferedWriter(new FileWriter(f.getAbsolutePath().replace(".in", ".out")))) {
                for(int i = 0; i < numOfRoutes; i++) {
                    String[] coordinates = s.nextLine().split(" ");
                    List<Coordinate> route = new ArrayList<>();
                    for (String coordinate : coordinates) {
                        String[] parts = coordinate.split(",");
                        route.add(new Coordinate(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
                    }

                    if(fieldO.isRouteValid(route)) {
                        outfile.write("VALID\n");
                    } else {
                        outfile.write("INVALID\n");
                    }
                }
            }

        }
    }

}
