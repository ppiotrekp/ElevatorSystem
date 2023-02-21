ElevatorSystem
An application which enables us to control the elevators in a building.

Algorithm works as below:
1. choose an id of the elevator.
2. choose a number of our ultimate floor (in this example we can choose floors from the range (-3,15)).
3. click 's' character to start ride or choose another ultimate floor (infinite times).
4. The elevator starts a ride and visits ultimate floors based on a minimal number of floors to visit (not based on an order of passed ultimate floors).
5. On each floor the status of an elevator is displayed.
6. On each ultimate floor the status of an elevator is updated.


The project consists of 
- elevator model class (id, currentFloor),
- Direction enum (UP, DOWN, NONE),
- ElevatorService interface with four methods (pickup, update, step and status) and two variables which defines minimal and maximal floor on a building
- ElevatorServiceImpl class which implements the ElevatorService interface and also has overloaded pickup method and setDirection and minLength methods.
- ElevatorManagement class where the algorithm is processed.

Description of methods:
