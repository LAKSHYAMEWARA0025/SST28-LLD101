import java.time.LocalDateTime;

public class InvoiceGenerator {
    public Invoice generate(Ticket t,double amount){
        return new Invoice(amount, t.getEntryTime(),LocalDateTime.now());
    }
}
