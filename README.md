ElevatorSystem - an application which enables us to control the elevators in a building.

Algorithm works as below:
1. choose an id of the elevator.
2. choose a number of our ultimate floor (in this example we can choose floors from the range (-3,15)).
3. click 's' character to start a ride or choose another ultimate floor (infinite times).
4. The elevator starts a ride and visits ultimate floors based on a minimal number of floors to visit (not based on an order of passed ultimate floors).
5. On each floor the status of an elevator is displayed.
6. On each ultimate floor the status of an elevator is updated.


The project consists of 
- elevator model class (id, currentFloor),
- Direction enum (UP, DOWN, NONE),
- ElevatorService interface with four methods (pickup, update, step and status) and two variables which define minimal and maximal floor on a building
- ElevatorServiceImpl class which implements the ElevatorService interface and also has overloaded pickup method and setDirection and minLength methods.
- ElevatorManagement class where the algorithm is processed.

Description of methods:
- pickup(Elevator elevator, int myFloor) - a method which returns a direction in which an elevator has to go and prints that information
- update(Elevator elevator, int currentFloor) - a method which updates a current floor of an elevator
- step(Elevator elevator, int floor) - a method which executes a simulation of every elevator's step (iteration through floors up to the ultimate floor and returns the status of an elevator on each floor)
- status(Integer id, int currentFloor, int destinationFloor) - a method which returns a status of elevator
- setDirection(int myFloor, int currentFloor) - a method which returns a direction in which an elevator has to go
- minLength(int floor, List<Integer> floors) - a method which returns the minimum difference between a current floor and a floor from the list of floors
- pickup(int floor, Direction direction) - a method which prints destination floor and direction
- run(List<Elevator> elevators) - a method in which the all algorithm is processed

![elevator1](https://user-images.githubusercontent.com/73071921/220354042-a5923d38-fe06-414d-9709-974550fce7f7.png)
![elevator2](https://user-images.githubusercontent.com/73071921/220354541-cf5385d0-ac4b-47a5-96c0-1b1efe00efeb.png)
![elevator3](https://user-images.githubusercontent.com/73071921/220354555-58496040-2259-4c11-857c-97889f520d59.png)
