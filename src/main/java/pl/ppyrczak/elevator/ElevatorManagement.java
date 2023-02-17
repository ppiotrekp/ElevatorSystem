package pl.ppyrczak.elevator;

import java.util.List;
import java.util.Scanner;

public class ElevatorManagement {
    public static void run(List<Elevator> elevators) {


        while (true) {
            ElevatorServiceImpl service = new ElevatorServiceImpl();
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
                    System.out.println("Next step is to set destination floor");
                    int floor = scanner.nextInt();
                    service.pickup(elevator, floor);
                    service.step(elevator, floor);
                    service.update(elevator, floor);
                }
            }
            System.out.println();
        }
    }
}
