package pl.ppyrczak.elevator;

import java.util.*;

import static java.lang.System.*;

public class ElevatorServiceImpl implements ElevatorService {

    /**
     * @param floor
     * @param direction
     * a method which prints destination floor and direction
     */
    private void pickup(int floor, Direction direction) {
        out.println("Elevator called, destination floor is: " + floor + ", direction is: " + direction);
    }

    /**
     * @param elevator
     * @param currentFloor
     * a method which updates a current floor of an elevator
     */
    @Override
    public void update(Elevator elevator, int currentFloor) {
        if (currentFloor <= MAX_FLOOR && currentFloor >= MIN_FLOOR)
            elevator.setCurrentFloor(currentFloor);
    }

    /**
     * @param elevator
     * @param floor
     * a method which executes a simulation of every elevator's step
     */
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

    /**
     * @param id
     * @param currentFloor
     * @param destinationFloor
     * @return
     * a method which returns a status of elevator
     */
    @Override
    public List<Integer> status(Integer id, int currentFloor, int destinationFloor) {
        return Arrays.asList(id, currentFloor, destinationFloor);
    }


    /**
     * @param elevator
     * @param myFloor
     * @return
     * a method which returns a direction in which
     * an elevator has to go and prints that information
     */
    @Override
    public Direction pickup(Elevator elevator, int myFloor) {
        Direction direction = setDirection(myFloor, elevator.getCurrentFloor());
        pickup(myFloor, direction);
        return direction;
    }

    /**
     * @param myFloor
     * @param currentFloor
     * @return
     * a method which returns a direction in which an elevator has to go
     */
    private Direction setDirection(int myFloor, int currentFloor) {
        if (myFloor > currentFloor)
            return Direction.UP;
        else if (myFloor < currentFloor)
            return Direction.DOWN;
        return Direction.NONE;
    }

    /**
     * @param floor
     * @param floors
     * @return
     * a method which returns the minimum difference between
     * a current floor and a floor from the list of floors
     */
    public int minLength(int floor, List<Integer> floors) {
        List<Integer> differences = new ArrayList<>();
        for (int f : floors) {
            differences.add(Math.abs(f-floor));
        }
        return Collections.min(differences);
    }
}
