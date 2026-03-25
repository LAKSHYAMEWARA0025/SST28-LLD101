import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Slot s1=new Slot(1,SlotType.SMALL,10);
        Slot s2=new Slot(2,SlotType.MEDIUM,20);
        level level=new level(1,Arrays.asList(s1,s2));

        Map<Slot,Integer> distanceMap=new HashMap<>();
        distanceMap.put(s1,5);
        distanceMap.put(s2,2);
        EntryGate gate=new EntryGate(1,distanceMap);
        ParkingLot parkingLot=new ParkingLot(Arrays.asList(level),new NearstSlotStrategy());
        Vehicle  vehicle=new Vehicle("RJ06CC6029",SlotType.MEDIUM);
        Ticket t=parkingLot.park(vehicle,gate);
        System.out.println("Parked at slot: "+t.getSlot().getSlotId());
        System.out.println("Exiting...");
        System.out.println("Amount: "+parkingLot.exit(t).getAmount());
    }
}
