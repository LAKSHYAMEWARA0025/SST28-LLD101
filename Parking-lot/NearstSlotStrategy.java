import java.util.List;
import java.util.Map;

public class NearstSlotStrategy implements ISlotStrategy {
    @Override
    public Slot findSlot(Vehicle v,EntryGate gate, List<level> levels){
        Slot bestSlot=null;
        int minDis=Integer.MAX_VALUE;
        Map<Slot,Integer> distanceMap=gate.getDistanceMap();
        for(level lev:levels){
            for(Slot slot:lev.getSlots()){
                if(slot.isAvailable() && slot.canFitVehicle(v)){
                    int dis=distanceMap.getOrDefault(slot,Integer.MAX_VALUE);
                    if(dis<minDis){
                        minDis=dis;
                        bestSlot=slot;
                    }    
                }
            }
        }
        if(bestSlot==null){
            throw new RuntimeException("No slot available");
        }
            return bestSlot;
    }
}
