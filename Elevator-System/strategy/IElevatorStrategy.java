package strategy;
import java.util.List;

import model.Elevator;

public interface IElevatorStrategy {
    Elevator assignElevator(int floor,List<Elevator> elevators);
}
