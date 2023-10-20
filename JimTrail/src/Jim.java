import java.util.ArrayList;
import java.util.List;

public class Jim {

    private final List<MoveAction> actions;
    public Jim(List<MoveAction> actions) {
        this.actions = actions;
    }
    public int calculateCircumference() {
        int length = 0;
        int direction = 0;

        for (MoveAction action : actions) {
            for (int i = 0; i < action.times(); i++) {
                for (char c : action.sequence().toCharArray()) {
                    switch (c) {
                        case 'F' -> length++;
                        case 'L' -> direction = (direction + 1) % 4;
                        case 'R' -> direction = (direction + 3) % 4;
                    }
                }
            }
        }
        return length;

    }
    public int calculateRectangularArea() {
        int x = 0;
        int y = 0;
        int direction = 0;
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;

        for (MoveAction action : actions) {
            for (int i = 0; i < action.times(); i++) {
                for (char c : action.sequence().toCharArray()) {
                    switch (c) {
                        case 'F' -> {
                            switch (direction) {
                                case 0 -> x++;
                                case 1 -> y++;
                                case 2 -> x--;
                                case 3 -> y--;
                            }
                        }
                        case 'L' -> direction = (direction + 1) % 4;
                        case 'R' -> direction = (direction + 3) % 4;
                    }
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
            }
        }
        return (maxX - minX) * (maxY - minY);
    }
    public int calculateCorrectArea() {
        List<Point> points = new ArrayList<>();

        int x = 0;
        int y = 0;
        int direction = 0;

        for (MoveAction action : actions) {
            for (int i = 0; i < action.times; i++) {
                for (char c : action.sequence.toCharArray()) {
                    switch (c) {
                        case 'F' -> {
                            switch (direction) {
                                case 0 -> x++;
                                case 1 -> y++;
                                case 2 -> x--;
                                case 3 -> y--;
                            }
                            points.add(new Point(x, y));
                        }
                        case 'L' -> {
                            direction = (direction + 1) % 4;
                        }
                        case 'R' -> {
                            direction = (direction + 3) % 4;
                        }
                    }
                }
                
            }
        }
        //use shoelace formula to calculate area
        int area = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            area += points.get(i).x() * points.get(i + 1).y();
            area -= points.get(i).y() * points.get(i + 1).x();
        }
        area += points.get(points.size() - 1).x() * points.get(0).y();
        area -= points.get(points.size() - 1).y() * points.get(0).x();
        return Math.abs(area) / 2;
    }
    public int calculatePocketSize() {
        //TODO implement

        return 0;
    }
    public record MoveAction(int times, String sequence) {}
    public record Point(int x, int y) {}
}
