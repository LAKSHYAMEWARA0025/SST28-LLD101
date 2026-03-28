package strategy;
import java.util.List;

import model.Elevator;

public class NearestElevatorStrategy implements IElevatorStrategy{
    public Elevator assignElevator(int floor, List<Elevator> elevators){
        Elevator best=null;
        int minDistance=Integer.MAX_VALUE;

        for(Elevator e:elevators){
            int dist=Math.abs(e.getCurrentFloor()-floor);
            if(dist<minDistance){
                minDistance=dist;
                best=e;
            }
        }
        return best;
    }
}
