class MessPricing implements PricingComponent {

    @Override
    public Money price(BookingRequest req) {
        return req.addOns.contains(AddOn.MESS)
                ? new Money(1000.00)
                : new Money(0.00);
    }
}