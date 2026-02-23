// public class InvoiceFormatter {
//     // pointless wrapper (smell)
//     public static String identityFormat(String s) { return s; }
// }

import java.util.*;

public class InvoiceFormatter {

    public String format(
            String invId,
            List<OrderLine> lines,
            Map<String, MenuItem> menu,
            PricingResult r
    ) {
        StringBuilder out = new StringBuilder();

        out.append("Invoice# ").append(invId).append("\n");

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            out.append(
                String.format(
                    "- %s x%d = %.2f\n",
                    item.name, l.qty, lineTotal
                )
            );
        }

        out.append(String.format("Subtotal: %.2f\n", r.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", r.taxPct, r.tax));
        out.append(String.format("Discount: -%.2f\n", r.discount));
        out.append(String.format("TOTAL: %.2f\n", r.total));

        return out.toString();
    }
}
