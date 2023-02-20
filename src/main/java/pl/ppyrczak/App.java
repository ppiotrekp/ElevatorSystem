package pl.ppyrczak;

import pl.ppyrczak.elevator.Elevator;
import pl.ppyrczak.elevator.ElevatorManagement;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Elevator elevator1 = new Elevator(1, 10);
        Elevator elevator2 = new Elevator(2, 11);
        Elevator elevator3 = new Elevator(3, 14);
        Elevator elevator4 = new Elevator(4, 2);
        Elevator elevator5 = new Elevator(5, 7);
        Elevator elevator6 = new Elevator(6, 1);

        List<Elevator> elevators = new ArrayList<>();
        elevators.add(elevator1);
        elevators.add(elevator2);
        elevators.add(elevator3);
        elevators.add(elevator4);
        elevators.add(elevator5);
        elevators.add(elevator6);

        ElevatorManagement.run(elevators);
    }
}
