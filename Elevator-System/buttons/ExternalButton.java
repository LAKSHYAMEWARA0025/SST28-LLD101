package buttons;
import model.Direction;
import requests.ExternalRequest;
import system.ElevatorSystem;
public class ExternalButton extends Button{
    private int floor;
    private Direction dir;
    private ElevatorSystem system;

    public ExternalButton(int floor, Direction dir, ElevatorSystem system){
        this.floor=floor;
        this.dir=dir;
        this.system=system;
    }
    public void press(){
        super.press();
        system.handleExternalRequest(new ExternalRequest(floor,dir));
    }
}
