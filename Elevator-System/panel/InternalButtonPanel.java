package panel;
import java.util.ArrayList;
import java.util.List;

import buttons.InternalButton;
import system.ElevatorSystem;

public class InternalButtonPanel {
    private List<InternalButton> buttons= new ArrayList<>();
    public InternalButtonPanel(int totalFloors, ElevatorSystem system){
        for(int i=0;i<totalFloors;i++){
            buttons.add(new InternalButton(i,system));
        }
    }
    public void pressButton(int floor){
        buttons.get(floor).press();
    }
}
