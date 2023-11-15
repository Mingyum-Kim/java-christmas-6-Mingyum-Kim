package christmas.service.promotion.discount;

import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.Discount;
import christmas.domain.promotion.Promotion;
import christmas.domain.promotion.PromotionResult;
import christmas.service.promotion.PromotionService;

public class ChristmasPromotion implements PromotionService<PromotionResult<Discount>> {
    private static final int INITIAL_DISCOUNT = 1000;
    private static final int DISCOUNT_INCREMENT = 100;
    private static final int START_DATE = 1;
    private static final int END_DATE = 25;

    @Override
    public PromotionResult<Discount> apply(Date date, Orders orders) {
        if (isQualified(date)) {
            return PromotionResult.of(
                    Promotion.CHRISTMAS,
                    Discount.from(calculateDiscountPrice(date))
            );
        }
        return PromotionResult.of(
                Promotion.CHRISTMAS,
                Discount.from(0)
        );
    }

    private boolean isQualified(Date date) {
        return date.isInRange(START_DATE, END_DATE);
    }

    private int calculateDiscountPrice(Date date) {
        return INITIAL_DISCOUNT + date.calculateTotalIncrement(DISCOUNT_INCREMENT);
    }
}
