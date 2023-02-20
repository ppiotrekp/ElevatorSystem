package pl.ppyrczak.elevator;

import java.util.List;

public interface ElevatorService {
    int MAX_FLOOR = 15;
    int MIN_FLOOR = -3;

    Direction pickup(Elevator elevator, int myFloor);
    void update(Elevator elevator, int currentFloor);
    void step(Elevator elevator, int floor);
    List<Integer> status(Integer id, int currentFloor, int destinationFloor);
}
