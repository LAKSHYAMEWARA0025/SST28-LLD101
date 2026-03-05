import java.util.*;

public class DeviceRegistry {
    private final java.util.List<Object> devices = new ArrayList<>();

    public void add(Object d) { devices.add(d); }

    // public Object getFirstOfType(String simpleName) { //WE HAVE MADE THE OBJECT TYPE TO BE GENERIC INSTEAD OF A SINGLE KIND OF OBJECT!!
    //     for (Object d : devices) {
    //         if (d.getClass().getSimpleName().equals(simpleName)) return d;
    //     }
    //     throw new IllegalStateException("Missing: " + simpleName);
    // }
    public <T> T getByCapability(Class<T> capability){
        for (Object d:devices){
            if(capability.isInstance(d)){
                return capability.cast(d);
            }
        }
        throw new IllegalStateException("Missing device for " + capability.getSimpleName());
    }
}
