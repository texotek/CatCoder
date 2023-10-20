import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        File[] directory = new File("level3").listFiles();
        assert directory != null;
        for (File file : directory) {
            if(file.getAbsolutePath().contains("out") || file.getAbsolutePath().contains("example")) continue;
            BufferedWriter outfile = new BufferedWriter(new FileWriter(file.getAbsolutePath().replace(".in", ".out")));
            try (Scanner s = new Scanner(file)) {
                int numTournaments;
                int numFighters;
                {
                    String[] text = s.nextLine().split(" ");
                    numTournaments = Integer.parseInt(text[0]);
                    numFighters = Integer.parseInt(text[1]);
                }

                for (int i = 0; i < numTournaments; i++) {

                    String[] text = s.nextLine().split(" ");
                    int rock = Integer.parseInt(text[0].substring(0, text[0].indexOf('R')));
                    int paper = Integer.parseInt(text[1].substring(0, text[1].indexOf('P')));
                    int scissors = Integer.parseInt(text[2].substring(0, text[2].indexOf('S')));
                    Tournament t = Tournament.generateScissorsWin(rock, paper, scissors);
                    assert t.getFighters().size() == numFighters;
                    outfile.write(t.toString());
                    outfile.newLine();
                    t.evaluateUntilLastRound();
                    System.out.println(t);
                }


                outfile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
