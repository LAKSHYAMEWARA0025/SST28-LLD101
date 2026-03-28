package requests;
public class InternalRequest {
    private int destinationFloor;

    public InternalRequest(int des){
        this.destinationFloor=des;
    }
    public int getDestinationFloor(){
        return destinationFloor;
    }
}
