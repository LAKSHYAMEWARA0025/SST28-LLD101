package model;
import observer.SensorObserver;
import java.util.ArrayList;
import java.util.List;

public class Elevator implements SensorObserver {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private List<Integer> requests;
    private double currentWeight;
    private final double maxWeight =700;
    private boolean isDoorOpen;

    public Elevator(int id){
        this.id=id;
        this.state=ElevatorState.IDLE;
        this.requests=new ArrayList<>();
    }

    public void addRequest(int floor){
        requests.add(floor);
    }
    public void move(){
        if(requests.isEmpty()){
            state=ElevatorState.IDLE;
            return;
        }
        int target=requests.get(0);
        if(target>currentFloor){
            direction=Direction.UP;
            state=ElevatorState.MOVING_UP;
            currentFloor++;
        }else if(target<currentFloor){
            direction=Direction.DOWN;
            state=ElevatorState.MOVING_DOWN;
            currentFloor--;
        }else{
            openDoor();
            requests.remove(0);
        }
    }
    public void openDoor(){
        isDoorOpen=true;
    }
    public void closeDoor(){
        isDoorOpen=false;
    }
    public void update(double weight,int floor, boolean isDoorOpen){
        this.currentWeight=weight;
        this.currentFloor=floor;
        this.isDoorOpen=isDoorOpen;
        
        if(currentWeight>maxWeight){
            System.out.println(" Elevator weight limit exceeded "+ id);
        }
    }
    public int getCurrentFloor(){
        return currentFloor;
    }
    public ElevatorState getState(){
        return state;
    }
}
