import java.util.List;

public class level {
    private int id;
    private List<Slot> slots;
    
    public level(int id, List<Slot> slots){
        this.id=id;
        this.slots=slots;
    }
    public List<Slot> getSlots(){
        return slots;
    }
}
