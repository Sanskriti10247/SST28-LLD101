import java.util.*;

class RoomPricing implements PricingComponent {

    private static final Map<Integer, Money> ROOM_PRICES = Map.of(
            LegacyRoomTypes.SINGLE, new Money(14000.00),
            LegacyRoomTypes.DOUBLE, new Money(15000.00),
            LegacyRoomTypes.TRIPLE, new Money(12000.00),
            LegacyRoomTypes.DELUXE, new Money(16000.00)
    );

    @Override
    public Money price(BookingRequest req) {
        return ROOM_PRICES.getOrDefault(
                req.roomType,
                new Money(16000.00)
        );
    }
}