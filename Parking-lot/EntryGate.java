import java.util.Map;

public class EntryGate {
    private int gateId;
    private Map<Slot,Integer> distanceMap;
    
    public EntryGate(int gateId,Map<Slot,Integer> distanceMap){
        this.gateId=gateId;
        this.distanceMap=distanceMap;
    }
    public Map<Slot,Integer> getDistanceMap(){
        return distanceMap;
    }
}
