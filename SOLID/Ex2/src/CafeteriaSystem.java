import java.util.*;

public class CafeteriaSystem {
    //menu mngmnt
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    // private final FileStore store = new FileStore();
    private final PricingEngine pricing;
    private final InvoiceFormatter formatter; 
    private final InvoiceRepository store;
    private final TaxRules taxPolicy;
    private final DiscountRules discountPolicy;
    private int invoiceSeq = 1000;
    CafeteriaSystem(PricingEngine pricing,InvoiceFormatter formatter, InvoiceRepository store, TaxRules taxPolicy,DiscountRules discountPolicy){
        this.pricing=pricing;
        this.formatter=formatter;
        this.store=store;
        this.taxPolicy=taxPolicy;
        this.discountPolicy=discountPolicy;
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        // StringBuilder out = new StringBuilder();
        // out.append("Invoice# ").append(invId).append("\n");

        //tax+discount+total+subtotal work happening here
        double subtotal = pricing.subtotal(menu,lines);
        // for (OrderLine l : lines) {
        //     MenuItem item = menu.get(l.itemId);
        //     double lineTotal = item.price * l.qty;
        //     subtotal += lineTotal;
        //     out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        // }
        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        DiscountPolicy policy=discountPolicy.discountAmount(customerType);
        double discount = policy.discount( subtotal, lines.size());

        double total = subtotal + tax - discount;
        String printable=formatter.identityFormat(invId,menu,lines,subtotal,taxPct,tax,discount,total);
        // //printing
        // out.append(String.format("Subtotal: %.2f\n", subtotal));
        // out.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        // out.append(String.format("Discount: -%.2f\n", discount));
        // out.append(String.format("TOTAL: %.2f\n", total));

        // String printable = InvoiceFormatter.identityFormat(out.toString());
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
