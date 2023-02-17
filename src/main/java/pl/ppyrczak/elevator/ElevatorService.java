package pl.ppyrczak.elevator;

import java.util.List;

public interface ElevatorService {
    Direction pickup(Elevator elevator, int myFloor);
    void update(Elevator elevator, int currentFloor);
    void step(Elevator elevator, int floor);
    List<Integer> status(Integer id, int currentFloor, int destinationFloor);
}
