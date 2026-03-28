package observer;
import java.util.ArrayList;
import java.util.List;

public class Sensor implements SensorObservable {
    private List<SensorObserver> observers=new ArrayList<>();

    private double weight;
    private int floor;
    private boolean isDoorOpen;

    public void addObserver(SensorObserver observer){
        observers.add(observer);
    }
    public void removeObserver(SensorObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(){
        for(SensorObserver o: observers){
            o.update(weight,floor,isDoorOpen);
        }
    }
    public void setSensorData(double weight,int floor, boolean isDoorOpen){
        this.weight=weight;
        this.floor=floor;
        this.isDoorOpen=isDoorOpen;
        notifyObservers();
    }
}
