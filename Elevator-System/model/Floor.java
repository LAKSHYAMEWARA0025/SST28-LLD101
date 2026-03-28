package model;
import panel.ExternalButtonPanel;
public class Floor {
    private int floorNumber;
    private ExternalButtonPanel panel;

    public Floor (int floor,ExternalButtonPanel panel){
        this.floorNumber=floor;
        this.panel=panel;
    }
    public ExternalButtonPanel getPanel(){
        return panel;
    }
}
