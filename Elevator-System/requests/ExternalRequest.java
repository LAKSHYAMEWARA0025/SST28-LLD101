package requests;
import model.Direction;

public class ExternalRequest {
    private int floor;
    private Direction direction;

    public ExternalRequest(int floor,Direction dir){
        this.floor=floor;
        this.direction=dir;
    }
    public int getFloor(){
        return floor;
    }
    public Direction getDirection(){
        return direction;
    }
}
