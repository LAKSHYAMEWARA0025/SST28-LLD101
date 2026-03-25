import java.time.LocalDateTime;

public class Ticket {
    private Vehicle vehicle;
    private Slot slot;
    private LocalDateTime entryTime;
    
    public Ticket(Vehicle vehicle, Slot slot, LocalDateTime entryTime){
        this.vehicle=vehicle;
        this.slot=slot;
        this.entryTime=entryTime;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public Slot getSlot(){
        return slot;
    }
    public LocalDateTime getEntryTime(){
        return entryTime;
    }

}
