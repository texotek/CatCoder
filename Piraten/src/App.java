import java.util.*;
import java.io.*;

public class App {

    public static boolean example = true;
    public static void main(String[]args) throws Exception {
        File level = new File("level5");
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
            int numOfCoordinates = s.nextInt();
            s.nextLine();
            try (BufferedWriter outfile = new BufferedWriter(new FileWriter(f.getAbsolutePath().replace(".in", ".out")))) {
                for (int i = 0; i < numOfCoordinates; i++) {
                    String[] line = s.nextLine().split(",");
                    Coordinate tile = new Coordinate(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
                    List<Coordinate> islandTiles = field.getIslandTiles(tile);
                    Coordinate start = islandTiles.get(0);


                }
            }

        }
    }

}
