import java.util.*;

class AddOnPricing implements PricingComponent {

    private static final Map<AddOn, Money> ADDON_PRICES = Map.of(
            AddOn.MESS, new Money(1000.00),
            AddOn.LAUNDRY, new Money(500.00),
            AddOn.GYM, new Money(300.00)
    );

    @Override
    public Money price(BookingRequest req) {
        Money total = new Money(0.0);
        for (AddOn a : req.addOns) {
            total = total.plus(
                    ADDON_PRICES.getOrDefault(a, new Money(0.0))
            );
        }
        return total;
    }
}