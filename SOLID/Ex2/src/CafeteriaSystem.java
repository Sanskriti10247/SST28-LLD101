import java.util.*;

public class CafeteriaSystem {

    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final PricingService pricing;
    private final InvoiceFormatter formatter;
    private final FileStore store;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(
            PricingService pricing,
            InvoiceFormatter formatter,
            FileStore store
    ) {
        this.pricing = pricing;
        this.formatter = formatter;
        this.store = store;
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {

        String invId = "INV-" + (++invoiceSeq);

        PricingResult result =
                pricing.calculate(customerType, lines, menu);

        String invoice = formatter.format(
                invId,
                lines,
                menu,
                result
        );

        System.out.print(invoice);
        store.save(invId, invoice);

        System.out.println(
                "Saved invoice: " + invId +
                " (lines=" + store.countLines(invId) + ")"
        );
    }
}