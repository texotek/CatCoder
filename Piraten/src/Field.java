import java.util.*;
public class Field {
    private final List<List<Character>> field;

    public Field(List<List<Character>> field) {
        this.field = field;
    }
    public List<Coordinate> getIslandTiles(Coordinate tile) {
        List<Coordinate> isLandTiles = new ArrayList<>();
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(tile);
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            if (this.field.get(current.getY()).get(current.getX()) == 'L') {
                isLandTiles.add(current);
                this.field.get(current.getY()).set(current.getX(), 'X');
                queue.addAll(getNeighbors(current, 'L'));
            }
        }
        isLandTiles.removeIf(coordinate -> getNeighbors(coordinate, 'W').isEmpty());
        return isLandTiles;
    }

    public List<Coordinate> findPath(Coordinate start, Coordinate end) {
        Map<Coordinate, Node> nodes = new HashMap<>();
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(Node::getEstimatedCost));
        Map<Coordinate, Coordinate> parents = new HashMap<>();

        Node startNode = new Node(start, 0, getEstimatedCost(start, end));
        nodes.put(start, startNode);
        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            Node currentNode = openSet.poll();
            if (currentNode.getCoordinate().equals(end)) {
                return reconstructPath(nodes, parents, start, end);
            }

            for (Coordinate neighbor : getNeighbors(currentNode.getCoordinate(), 'W')) {
                if (this.field.get(neighbor.getY()).get(neighbor.getX()) == 'L') {
                    continue;
                }

                double newCost = currentNode.getCost() + 1;
                Node neighborNode = nodes.getOrDefault(neighbor, new Node(neighbor, Double.MAX_VALUE, 0));
                if (newCost < neighborNode.getCost()) {
                    neighborNode.setCost(newCost);
                    neighborNode.setEstimatedCost(newCost + getEstimatedCost(neighbor, end));
                    nodes.put(neighbor, neighborNode);
                    openSet.add(neighborNode);
                    parents.put(neighbor, currentNode.getCoordinate());
                }
            }
        }

        return null;
    }
    private List<Coordinate> reconstructPath(Map<Coordinate, Node> nodes, Map<Coordinate, Coordinate> parents, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate current = end;
        while (current != null) {
            path.add(0, current);
            current = parents.get(current);
        }
        return path;
    }
    private double getEstimatedCost(Coordinate from, Coordinate to) {
        return Math.abs(from.getX() - to.getX()) + Math.abs(from.getY() - to.getY());
    }
    private List<Coordinate> getNeighbors(Coordinate coordinate, char type) {
        int[] dx = {-1, 0, 1, -1, 1, -1, 1, 0};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        List<Coordinate> neighbors = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int newX = coordinate.getX() + dx[i];
            int newY = coordinate.getY() + dy[i];
            if (newX >= 0 && newX < field.get(0).size() && newY >= 0 && newY < field.size() &&
                    field.get(newY).get(newX) == type) {
                neighbors.add(new Coordinate(newX, newY));
            }
        }
        return neighbors;
    }
    public List<List<Character>> getField() {
        return field;
    }
}
