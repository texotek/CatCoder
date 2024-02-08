public class Line {
    private final Coordinate start;
    private final Coordinate end;

    public Line(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
    }

    public boolean intersects(Line other) {
        double x1 = this.start.getX(), y1 = this.start.getY();
        double x2 = this.end.getX(), y2 = this.end.getY();
        double x3 = other.start.getX(), y3 = other.start.getY();
        double x4 = other.end.getX(), y4 = other.end.getY();

        // Calculate the slopes of the lines
        double a1 = (y2 - y1) / (x2 - x1);
        double b1 = y1 - a1 * x1;
        double a2 = (y4 - y3) / (x4 - x3);
        double b2 = y3 - a2 * x3;

        // Check if the lines are parallel
        if (a1 == a2) {
            return false;
        }

        // Calculate the x coordinate of the intersection
        double x0 = -(b1 - b2) / (a1 - a2);

        // Check if the intersection point lies within both segments
        return Math.min(x1, x2) < x0 && x0 < Math.max(x1, x2) &&
                Math.min(x3, x4) < x0 && x0 < Math.max(x3, x4);
    }

}
