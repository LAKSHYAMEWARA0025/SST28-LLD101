import java.util.HashMap;

public class PenFactory {
    //the work of pen factory is to provide neccessary objects of neccessary class
    HashMap<String,IPenType> penmap=new HashMap<>();
    HashMap<String,IRefillType> refillmap=new HashMap<>();
    HashMap<String,IMechanismType> mechanismmap=new HashMap<>();
    
    public PenFactory() {
        penmap.put("ball",new BallPen());
        penmap.put("gel",new GelPen());
        penmap.put("ink",new InkPen());
        mechanismmap.put("cap",new Cap());
        mechanismmap.put("click",new Click());
        refillmap.put("ink",new InkFill());
        refillmap.put("direct",new DirectFill());
    }
    public IPenType getPen(String s){
        return penmap.get(s);
    }
    public IMechanismType getMechanism(String s){
        return mechanismmap.get(s);
    }
    public IRefillType getRefill(String s){
        return refillmap.get(s);
    }
    //humlog penfactory kii madad se pen object banaayege, main class mein penfactory on basis of string pen ko objects provide karega 
}
