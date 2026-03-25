import java.time.LocalDateTime;
import java.util.List;

public class ParkingLot {
    private List<level> levels;
    private ISlotStrategy strategy;
    private PaymentService paymentService;
    private InvoiceGenerator invoiceGenerator;

    public ParkingLot(List<level> levels, ISlotStrategy strategy){
        this.levels=levels;
        this.strategy=strategy;
        this.paymentService=new PaymentService();
        this.invoiceGenerator=new InvoiceGenerator();
    }

    public Ticket park(Vehicle v,EntryGate gate){
        Slot slot=strategy.findSlot(v,gate,levels);
        slot.occupy();
        return new Ticket(v,slot,LocalDateTime.now());
    }
    public Invoice exit(Ticket t){
        t.getSlot().free();
        double amount=paymentService.calculateAmount(t);
        return invoiceGenerator.generate(t,amount);
    }
}
