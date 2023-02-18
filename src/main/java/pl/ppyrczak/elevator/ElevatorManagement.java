package pl.ppyrczak.elevator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.SECONDS;

public class ElevatorManagement {
    public static void run(List<Elevator> elevators) {

        while (true) {
            ElevatorServiceImpl service = new ElevatorServiceImpl();
            List<Integer> floors = new ArrayList<>();
            System.out.println("--------------ELEVATOR SYSTEM--------------");
            System.out.println("Which elevator do you want to call? ");
            System.out.println("ID  FLOOR");
            for (Elevator elevator : elevators) {
                System.out.println(elevator.getId() + "     " + elevator.getCurrentFloor());
            }
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();

            for (Elevator elevator : elevators) {
                if (elevator.getId() == number) {
                    System.out.println("You've choosen an elevator with id " + elevator.getId());
                    System.out.println("Next step is to set a destination floor");
                    LocalDateTime start = LocalDateTime.now();
                    long between;
                    while (floors.isEmpty() || SECONDS.between(start, LocalDateTime.now()) <= 2) {
                        between = SECONDS.between(start, LocalDateTime.now());
                        if (!floors.isEmpty() && between >= 3) {
                            break;
                        }
                        int floor = scanner.nextInt();
                        floors.add(floor);
                    }

                    while (!floors.isEmpty()) {
                        service.pickup(elevator, floors.get(0));
                        service.step(elevator, floors.get(0));
                        service.update(elevator, floors.get(0));
                        floors.remove(0);
                    }
                }
            }
            System.out.println();
        }
    }
}
