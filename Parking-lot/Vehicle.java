public class Vehicle {
    private String vehicleNumber;
    private SlotType type;
    public Vehicle(String vehicleNumber,SlotType type){
        this.vehicleNumber=vehicleNumber;
        this.type=type;
    }
    public String getVehicleNumber(){
        return this.vehicleNumber;
    }
    public SlotType getType(){
        return type;
    }
}
