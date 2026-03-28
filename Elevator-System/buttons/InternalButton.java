// import model.ElevatorState;
package buttons;

import requests.InternalRequest;
import system.ElevatorSystem;

public class InternalButton extends Button {
    private int floor;
    private ElevatorSystem system;
    public InternalButton(int floor,ElevatorSystem system){
        this.floor=floor;
        this.system=system;
    }

    public void press(){
        super.press();
        system.handleInternalRequest(new InternalRequest(floor));
    }
}
