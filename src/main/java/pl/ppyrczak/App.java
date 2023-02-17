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

        List<Elevator> elevators = new ArrayList<>();
        elevators.add(elevator1);
        elevators.add(elevator2);
        elevators.add(elevator3);

        ElevatorManagement.run(elevators);
    }
}
