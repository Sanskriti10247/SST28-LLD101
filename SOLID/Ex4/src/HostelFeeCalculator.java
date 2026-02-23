import java.util.*;

public class HostelFeeCalculator {

    private final FakeBookingRepo repo;
    private final List<PricingComponent> components;

    public HostelFeeCalculator(
            FakeBookingRepo repo,
            List<PricingComponent> components
    ) {
        this.repo = repo;
        this.components = components;
    }

    public void process(BookingRequest req) {

        Money monthly = new Money(0.0);
        for (PricingComponent pc : components) {
            monthly = monthly.plus(pc.price(req));
        }

        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId =
                "H-" + (7000 + new Random(1).nextInt(1000));

        repo.save(bookingId, req, monthly, deposit);
    }
}