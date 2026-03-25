public class Slot {
    private int slotId;
    private SlotType type;
    private double hourlyRate;
    private boolean isOccupied;
    public Slot(int slotId, SlotType type, double hourlyRate){
        this.slotId=slotId;
        this.type=type;
        this.hourlyRate=hourlyRate;
        this.isOccupied=false;
    }
    public boolean canFitVehicle(Vehicle vehicle){
        return vehicle.getType().ordinal() <= this.type.ordinal();
    }
    public boolean isAvailable(){
        return !isOccupied;
    }
    public void occupy(){
        this.isOccupied=true;
    }
    public void free(){
        this.isOccupied=false;
    }
    public double getHourlyRate(){
        return hourlyRate;
    }
    public int getSlotId(){
        return slotId;
    }
    public SlotType getType(){
        return type;
    }
}
