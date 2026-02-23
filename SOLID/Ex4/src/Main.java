import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        List<AddOns> a=Arrays.asList(
            new LaundryAddOn(),
            new MessAddOn()
        );
        BookingRequest req = new BookingRequest(new DoubleRoom(), a);
        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo());
        calc.process(req);
        // String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        // repo.save(bookingId, req, monthly, deposit);
    }
}
