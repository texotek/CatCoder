import java.util.*;
import java.util.stream.Collectors;

public class Field {
    public List<List<Character>> field;

    public Field(List<List<Character>> field) {
        this.field = field;
    }
    public char getType(int x, int y) {
        return this.field.get(y).get(x);
    }

    public boolean isOnSame(Coordinate a, Coordinate b) {
        if (field.get(a.y()).get(a.x()) != 'L' || field.get(b.y()).get(b.x()) != 'L') {
            return false;
        }
        ArrayList<List<Character>> copy = new ArrayList<>(field.stream().map(ArrayList::new).toList());
        return depthFirstSearch(copy, a,b);
    }
    private static boolean depthFirstSearch(List<List<Character>> grid, Coordinate current, Coordinate target) {

//        System.out.println(printField(grid));
        int rows = grid.size();
        int cols = grid.get(0).size();

        int x = current.x();
        int y = current.y();

        if (y < 0 || y >= rows || x < 0 || x >= cols || grid.get(y).get(x) == 'W' || grid.get(y).get(x) == 'X') {
            return false;
        }

        if (current.equals(target)) {
            return true;
        }

        grid.get(y).set(x, 'X'); // Mark the current cell as visited

        // Recursively check adjacent cells
        List<Coordinate> adjacentCoordinates = List.of(
                new Coordinate(x - 1, y),
                new Coordinate(x + 1, y),
                new Coordinate(x, y - 1),
                new Coordinate(x, y + 1)
        );

        for (Coordinate neighbor : adjacentCoordinates) {
            if (depthFirstSearch(grid, neighbor, target)) {
                return true;
            }
        }

        return false;
    }
    public static String printField(List<List<Character>> field) {
        StringBuilder sb = new StringBuilder();
        for (List<Character> row : field) {
            for (Character c : row) {
                sb.append(c);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Character> row : field) {
            for (Character c : row) {
                sb.append(c);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public boolean isRouteValid(List<Coordinate> route) {
        List<Line> lines = new ArrayList<>();
        Set<Coordinate> visited = new HashSet<>();
        for (int i = 0; i < route.size() - 1; i++) {
            Coordinate current = route.get(i);
            Coordinate next = route.get(i + 1);
            lines.add(new Line(current, next));
            if (!visited.add(current)) {
                return false;
            }
        }
        if (!visited.add(route.get(route.size() - 1))) {
            return false;
        }

        for (int i = 0; i < lines.size(); i++) {
            for (int j = i + 1; j < lines.size(); j++) {
                if (lines.get(i).intersects(lines.get(j))) {
                    return false;
                }
            }
        }

        return true;
    }




}