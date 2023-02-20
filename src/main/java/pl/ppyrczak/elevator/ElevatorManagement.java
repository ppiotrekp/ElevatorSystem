package pl.ppyrczak.elevator;

import java.util.*;

import static java.lang.System.out;
import static pl.ppyrczak.elevator.ElevatorService.MAX_FLOOR;
import static pl.ppyrczak.elevator.ElevatorService.MIN_FLOOR;

public class ElevatorManagement {
    private static boolean started = false;
    private static int firstFloor;

    /**
     * @param elevators
     * a method which handle the all logic of elevators' movement
     */
    public static void run(List<Elevator> elevators) {
        while (true) {
            ElevatorServiceImpl service = new ElevatorServiceImpl();
            List<Integer> floors = new ArrayList<>();
            out.println("--------------ELEVATOR SYSTEM--------------");
            out.println("Which elevator do you want to call? ");
            out.println("ID  FLOOR");
            for (Elevator elevator : elevators) {
                out.println(elevator.getId() + "     " + elevator.getCurrentFloor());
            }
            out.println();
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();

            for (Elevator elevator : elevators) {
                if (elevator.getId() == number) {
                    out.println("You've choosen an elevator with id " + elevator.getId());
                    out.println("Next step is to set a destination floor");
                    while (!started) {
                        out.println("choose a floor from " + MIN_FLOOR + " to " + MAX_FLOOR);
                        String floor = scanner.next();
                        floors.add(Integer.valueOf(floor));

                        while (!floors.isEmpty()) {
                            out.println("choose a floor from " + MIN_FLOOR + " to " + MAX_FLOOR);
                            out.println("Start - s");
                            floor = scanner.next();
                            if (floor.equals("s")) {
                                started = true;
                                break;
                            } else
                                floors.add(Integer.valueOf(floor));
                        }
                    }

                    while (!floors.isEmpty()) {
                        for (Integer f : floors) {
                            if (service.minLength(elevator.getCurrentFloor(), floors) == Math.abs(f - elevator.getCurrentFloor())) {
                                firstFloor = f;
                            }
                        }
                        service.pickup(elevator, firstFloor);
                        service.step(elevator, firstFloor);
                        out.println();
                        service.update(elevator, firstFloor);
                        floors.remove((Integer) firstFloor);
                        started = false;
                    }
                }
            }
            out.println();
        }
    }
}
