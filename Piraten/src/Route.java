import java.util.*;
public class Route {
    private final List<Coordinate> coordinates;

    public Route(Coordinate start) {
        this.coordinates = new ArrayList<>();
        this.coordinates.add(start);
    }

    public void addCoordinate(Coordinate coordinate) {
        this.coordinates.add(coordinate);
    }

    public boolean isValid(Field field, int maxRouteLength) {
        if (this.coordinates.size() > maxRouteLength) {
            return false;
        }

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < this.coordinates.size() - 1; i++) {
            lines.add(new Line(this.coordinates.get(i), this.coordinates.get(i + 1)));
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
