package christmas.service.promotion;

import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.Discount;
import java.util.Arrays;

public class SpecialPromotion implements PromotionService<Discount> {
    private static final int[] specialDays = {
            3, 10, 17, 24, 25, 31
    };
    private static final int DISCOUNT_PRICE = 1000;

    @Override
    public Discount apply(Date date, Orders orders) {
        if (isQualified(date)) {
            return Discount.from(DISCOUNT_PRICE);
        }
        return Discount.from(0);
    }

    private boolean isQualified(Date date) {
        return Arrays.stream(specialDays)
                .anyMatch(day -> date.equals(day));
    }
}
