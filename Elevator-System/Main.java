import java.util.Arrays;
import model.Elevator;
import observer.Sensor;
import system.ElevatorSystem;
import strategy.NearestElevatorStrategy;

public class Main{
    public static void main(String[] args){
        Elevator e1=new Elevator(1);
        Elevator e2=new Elevator(2);

        Sensor sensor1=new Sensor();
        Sensor sensor2=new Sensor();
        sensor1.addObserver(e1);
        sensor2.addObserver(e2);

        ElevatorSystem system= new ElevatorSystem(
            Arrays.asList(e1,e2),
            new NearestElevatorStrategy()
        );
        //stimulate sensor updates
        sensor1.setSensorData(500,1,false);
        sensor2.setSensorData(800,2,true);

        //stimulate button press
        // system.requestElevator(5);
        
    }
}