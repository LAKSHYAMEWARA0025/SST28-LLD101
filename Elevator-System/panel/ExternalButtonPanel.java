package panel;
import buttons.ExternalButton;
import model.Direction;
import system.ElevatorSystem;
public class ExternalButtonPanel {
    private ExternalButton upButton;
    private ExternalButton downButton;

    public ExternalButtonPanel(int floor,ElevatorSystem system){
        this.upButton=new ExternalButton(floor,Direction.UP,system);
        this.downButton=new ExternalButton(floor,Direction.DOWN,system);
    }

    public void pressUp(){
        upButton.press();
    }
    public void pressDown(){
        downButton.press();
    }
}
