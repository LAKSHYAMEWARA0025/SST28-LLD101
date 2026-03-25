import java.time.LocalDateTime;

public class Invoice {
    private double amount;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Invoice(double amount, LocalDateTime entryTime, LocalDateTime exitTime){
        this.amount=amount;
        this.entryTime=entryTime;
        this.exitTime=exitTime;
    }
    public double getAmount(){
        return amount;
    }
}
