import java.time.Duration;
import java.time.LocalDateTime;

public class PaymentService {
    public double calculateAmount(Ticket t){
        LocalDateTime now=LocalDateTime.now();
        long hrs=Math.max(1,Duration.between(t.getEntryTime(),now).toHours());
        return hrs * t.getSlot().getHourlyRate();
    }
}
