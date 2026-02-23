import java.util.*;
//we have to modify booking request in order to remove switch and ENUMS and add concrete classes at their place
public class BookingRequest {
    public final RoomType room;
    public final List<AddOns> addOns;

    public BookingRequest(RoomType roomType, List<AddOns> addOns) {
        this.room = roomType;
        this.addOns = addOns;
    }
    public RoomType getRoom(){
        return room;
    }
    public List<AddOns> getAddOns(){
        return addOns;
    }
    public String name(){
        return room.name();
    }
}
