public class BookingService {
    private final HostelFeeCalculator calculator;
    private final BookingRepository repo;
    private final ReceiptPrinter printer;
    private final BookingIdGenerator idGenerator;
    private final DepositPolicy depositpolicy;
    //we have used all the interfaces over here
    BookingService(HostelFeeCalculator calculator,BookingRepository repo,ReceiptPrinter printer,BookingIdGenerator idGenerator,DepositPolicy deposit){
        this.calculator=calculator;
        this.repo=repo;
        this.printer=printer;
        this.idGenerator=idGenerator;
        this.depositpolicy=deposit;
    }
    public void process(BookingRequest req){
        Money monthly=calculator.calculateMonthly(req);
        Money deposit=depositpolicy.deposit();
        printer.print(req,monthly,deposit);
        String id=idGenerator.generate();
        repo.save(id,req,monthly,deposit);
    }
}
