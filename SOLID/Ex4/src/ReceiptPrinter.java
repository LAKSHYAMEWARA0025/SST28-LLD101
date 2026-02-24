// import java.util.*;

public class ReceiptPrinter {
    public void print(BookingRequest req, Money monthly, Money deposit) { //making this non-static
        // System.out.println("Room: " + req.name() + " | AddOns: " + req.addOns);
        System.out.print("Room: " + req.getRoom().name());
        System.out.print(" | AddOns: ");

        if (req.getAddOns().isEmpty()) {
            System.out.println("None");
        } else {
            System.out.print("[");
            for (int i = 0; i < req.getAddOns().size(); i++) {
                System.out.print(req.getAddOns().get(i).name());

                if (i < req.getAddOns().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        System.out.println("Monthly: " + monthly);
        System.out.println("Deposit: " + deposit);
        System.out.println("TOTAL DUE NOW: " + monthly.plus(deposit));
    }
}
