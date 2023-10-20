import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        File level = new File("level3");
        for (File file : Objects.requireNonNull(level.listFiles())) {
            if(file.getName().contains(".out") || !file.getName().contains("example")) continue;
            Scanner s = new Scanner(file);
            int count = Integer.parseInt(s.nextLine());
            int[] minutes =  new int[count];
            for (int i = 0; i < count; i++) {
                minutes[i] = Integer.parseInt(s.nextLine());
            }
            count = Integer.parseInt(s.nextLine());
            Task[] tasks = new Task[count];
            for (int i = 0; i < count; i++) {
                String[] split = s.nextLine().split(" ");
                tasks[i] = new Task(Integer.parseInt(split[0]),
                        Integer.parseInt(split[1]),
                        Integer.parseInt(split[2]),
                        Integer.parseInt(split[3])
                );
            }
            Grid grid = new Grid(minutes, tasks);
            Task[] outTasks = grid.cheapestIntervals();

            File outFile = new File(file.toPath().toString().replace(".in", ".out"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

            writer.write(outTasks.length + "\n");
            for (Task task : outTasks) {
                writer.write(task.toString() + "\n");
            }

            //writer.close();
            break;
        }

    }

}
