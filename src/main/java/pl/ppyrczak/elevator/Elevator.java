package pl.ppyrczak.elevator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Elevator {
    private Integer id;
    private int currentFloor;
}
