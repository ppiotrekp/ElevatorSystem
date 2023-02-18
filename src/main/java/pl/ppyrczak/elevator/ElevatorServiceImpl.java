package pl.ppyrczak.elevator;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;

public class ElevatorServiceImpl implements ElevatorService {

    private void pickup(int floor, Direction direction) {
        out.println("Elevator called, destination floor is: " + floor + ", direction is: " + direction);
    }

    @Override
    public void update(Elevator elevator, int currentFloor) {
        if (currentFloor <= MAX_FLOOR && currentFloor >= MIN_FLOOR)
            elevator.setCurrentFloor(currentFloor);
    }

    @Override
    public void step(Elevator elevator, int floor) {
        List<Integer> statusInfo;
        if (floor <= MAX_FLOOR && floor >= MIN_FLOOR) {
            if (elevator.getCurrentFloor() < floor) {
                for (int i = elevator.getCurrentFloor(); i <= floor; i++) {
                    statusInfo = status(elevator.getId(), i, floor);
                    if (i != floor)
                        out.println("Elevator with id " + statusInfo.get(0) + " is on " + statusInfo.get(1) + ", destination floor is " + floor);
                    else out.println("Destination floor reached: " + floor);
                }
            } else if (elevator.getCurrentFloor() > floor) {
                for (int i = elevator.getCurrentFloor(); i >= floor; i--) {
                    statusInfo = status(elevator.getId(), i, floor);
                    if (i != floor)
                        out.println("Elevator with id " + statusInfo.get(0) + " is on " + statusInfo.get(1) + ", destination floor is " + floor);
                    else out.println("Destination floor reached: " + floor);
                }
            } else {
                out.println("You have to pass a floor different from the current one!");
            }
        } else {
            out.println("FLOOR NUMBER " + floor + " UNAVAILABLE!");
        }
    }

    @Override
    public List<Integer> status(Integer id, int currentFloor, int destinationFloor) {
        return Arrays.asList(id, currentFloor, destinationFloor);
    }

    @Override
    public Direction pickup(Elevator elevator, int myFloor) {
        Direction direction = setDirection(myFloor, elevator.getCurrentFloor());
        pickup(myFloor, direction);
        return direction;
    }

    private Direction setDirection(int myFloor, int currentFloor) {
        if (myFloor > currentFloor)
            return Direction.UP;
        else if (myFloor < currentFloor)
            return Direction.DOWN;
        return Direction.NONE;
    }

}
