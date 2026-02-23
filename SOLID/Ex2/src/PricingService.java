import java.util.*;

public class PricingService {

    public PricingResult calculate(
            String customerType,
            List<OrderLine> lines,
            Map<String, MenuItem> menu
    ) {
        double subtotal = 0.0;

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            subtotal += item.price * l.qty;
        }

        double taxPct = TaxRules.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        double discount =
                DiscountRules.discountAmount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;

        return new PricingResult(subtotal, tax, taxPct, discount, total);
    }
}

class PricingResult {
    final double subtotal;
    final double tax;
    final double taxPct;
    final double discount;
    final double total;

    PricingResult(double s, double t, double p, double d, double tot) {
        subtotal = s;
        tax = t;
        taxPct = p;
        discount = d;
        total = tot;
    }
}