package jamcity;

import java.util.List;

public class Road {
    private Car[] segements;

    public Road(int segmentCount) {
        this.segements = new Car[segmentCount];
    }
    void addCar(Car car) {
        segements[car.start() - 1] = car;
    }

    List<Integer> calculateTimes() {

        return null;
    }

}
