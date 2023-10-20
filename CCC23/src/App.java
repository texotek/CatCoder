import java.io.*;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        File level = new File("level3");

        File[] testfiles = level.listFiles();
        for(File f : testfiles) {
            if(f.getAbsolutePath().contains(".out")) continue;
            if(f.getAbsolutePath().contains("example")) continue;
            if(f.getAbsolutePath().contains("visualizer")) continue;

            Scanner s = new Scanner(f);
            // make a lisst of pieces int a list
            List<List<PuzzlePiece>> pieces = new ArrayList<>();
            int numofpieces = s.nextInt();
            s.nextLine();

            for (int i = 0; i < numofpieces; i++) {
                String[] strpieces = s.nextLine().split(" ");
                ArrayList<PuzzlePiece> line = new ArrayList<>();
                for(String str : strpieces) {
                    line.add(PuzzlePiece.readPiece(str.split(",")));
                }
                pieces.add(line);
            }

            Puzzle p = new Puzzle(pieces);
            System.out.println(p.correctPuzzle());


            try (BufferedWriter outfile = new BufferedWriter(new FileWriter(f.getAbsolutePath().replace(".in", ".out")))) {
                outfile.write(p.correctPuzzle().toString());
            }
        }
    }
}
