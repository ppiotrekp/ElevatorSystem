package pl.ppyrczak.elevator;

import java.util.Arrays;
import java.util.List;

public class ElevatorServiceImpl implements ElevatorService {
    private static final int MAX_FLOOR = 15;
    private static final int MIN_FLOOR = -3;

    private void pickup(int floor, Direction direction) {
        System.out.println("Elevator called, destination floor is: " + floor + ", direction is: " + direction);
    }

    @Override
    public void update(Elevator elevator, int currentFloor) {
        elevator.setCurrentFloor(currentFloor);
    }

    @Override
    public void step(Elevator elevator, int floor) {
        List<Integer> statusInfo;
        if (elevator.getCurrentFloor() < floor) {
            for (int i = elevator.getCurrentFloor(); i <= floor; i++) {
                statusInfo = status(elevator.getId(), i, floor);
                if (i != floor)
                    System.out.println("Elevator with id " + statusInfo.get(0) + " is on " + statusInfo.get(1) + ", destination floor is " + floor);
                else System.out.println("Destination floor reached: " + floor);
            }
        } else if (elevator.getCurrentFloor() > floor) {
            for (int i = elevator.getCurrentFloor(); i >= floor; i--) {
                statusInfo = status(elevator.getId(), i, floor);
                if (i != floor)
                    System.out.println("Elevator with id " + statusInfo.get(0) + " is on " + statusInfo.get(1) + ", destination floor is " + floor);
                else System.out.println("Destination floor reached: " + floor);
            }
        } else {
            System.out.println("You have to pass a floor different from the current one!");
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
