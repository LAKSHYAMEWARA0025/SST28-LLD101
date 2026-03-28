package system;
import java.util.List;

import model.Elevator;
import requests.ExternalRequest;
import requests.InternalRequest;
import strategy.IElevatorStrategy;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private IElevatorStrategy strategy;

    public ElevatorSystem(List<Elevator> elevators,IElevatorStrategy strategy){
        this.elevators=elevators;
        this.strategy=strategy;
    }
    public void handleExternalRequest(ExternalRequest request){
        Elevator ele=strategy.assignElevator(request.getFloor(),elevators);
        ele.addRequest(request.getFloor());
        System.out.println("External request handled for floor: "+request.getFloor());
    }
    public void handleInternalRequest(InternalRequest request){
        //currently assigning to first elevator
        elevators.get(0).addRequest(request.getDestinationFloor());
    }
}
