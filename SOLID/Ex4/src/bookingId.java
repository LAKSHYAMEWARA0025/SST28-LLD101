import java.util.Random;

public class bookingId implements BookingIdGenerator{
    public String generate(){
        return "H-" + (7000 + new Random(1).nextInt(1000));
    }
}
