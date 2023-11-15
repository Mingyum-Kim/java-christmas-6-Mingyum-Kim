package christmas.service.promotion.discount;

import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.Discount;
import christmas.domain.promotion.Promotion;
import christmas.domain.promotion.PromotionResult;
import christmas.service.promotion.PromotionService;
import java.util.Arrays;

public class SpecialPromotion implements PromotionService<PromotionResult<Discount>> {
    private static final int[] specialDays = {
            3, 10, 17, 24, 25, 31
    };
    private static final int DISCOUNT_PRICE = 1_000;

    @Override
    public PromotionResult<Discount> apply(Date date, Orders orders) {
        if (isQualified(date)) {
            return PromotionResult.of(
                    Promotion.SPECIAL,
                    Discount.from(DISCOUNT_PRICE)
            );
        }
        return PromotionResult.of(
                Promotion.SPECIAL,
                Discount.from(0)
        );
    }

    private boolean isQualified(Date date) {
        return Arrays.stream(specialDays)
                .anyMatch(day -> date.equals(day));
    }
}
