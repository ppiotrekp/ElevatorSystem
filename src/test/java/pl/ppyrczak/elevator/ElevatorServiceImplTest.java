package pl.ppyrczak.elevator;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ElevatorServiceImplTest extends TestCase {
    private final ElevatorServiceImpl service = new ElevatorServiceImpl();

    public void testPickupUp() {
        //given
        Elevator elevator = new Elevator(1, 4);
        // when
        Direction direction = service.pickup(elevator, 8);
        // then
        Assert.assertEquals(Direction.UP, direction);
    }

    public void testPickupDown() {
        //given
        Elevator elevator = new Elevator(1, 4);
        // when
        Direction direction = service.pickup(elevator, 0);
        // then
        Assert.assertEquals(Direction.DOWN, direction);
    }

    public void testUpdate() {
        // given
        Elevator elevator = new Elevator(1, 3);
        // when
        service.update(elevator, 10);
        // then
        Assert.assertEquals(10, elevator.getCurrentFloor());
    }

    public void testStep() {

    }

    public void testStatus() {
        Elevator elevator = new Elevator(2, 11);
        int destinationFloor = 15;
        List<Integer> statusInfo = new ArrayList<>();
        statusInfo.add(elevator.getId());
        statusInfo.add(elevator.getCurrentFloor());
        statusInfo.add(destinationFloor);

        Assert.assertEquals(11, (int) statusInfo.get(1));
        Assert.assertEquals(2, (int) statusInfo.get(0));
        Assert.assertEquals(15, (int) statusInfo.get(2));
    }
}