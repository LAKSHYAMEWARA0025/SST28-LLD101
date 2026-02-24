import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        List<AddOns> a=Arrays.asList(
            new LaundryAddOn(),
            new MessAddOn()
        );
        BookingRequest req = new BookingRequest(new DoubleRoom(), a);
        // HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo());
        // calc.process(req);
        BookingService book=new BookingService(new HostelFeeCalculator(),new FakeBookingRepo(),new ReceiptPrinter(),new bookingId(),new FixedDepositPolicy());
        book.process(req);
    }
}
