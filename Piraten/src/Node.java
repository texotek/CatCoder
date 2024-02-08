public class Node {
    private final Coordinate coordinate;
    private double cost;
    private double estimatedCost;

    public Node(Coordinate coordinate, double cost, double estimatedCost) {
        this.coordinate = coordinate;
        this.cost = cost;
        this.estimatedCost = estimatedCost;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getCost() {
        return cost;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}
