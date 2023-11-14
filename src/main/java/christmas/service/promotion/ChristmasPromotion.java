package christmas.service.promotion;

import christmas.domain.customer.Customer;
import christmas.domain.promotion.Discount;

public class ChristmasPromotion implements PromotionService<Discount> {
    private static final int INITIAL_DISCOUNT = 1000;
    private static final int DISCOUNT_RISE = 100;
    private static final int START_DATE = 1;
    private static final int END_DATE = 25;

    @Override
    public Discount apply(Customer customer) {
        if (isQualified(customer)) {
            return Discount.from(calculateDiscountPrice(customer));
        }
        return Discount.from(0);
    }

    private boolean isQualified(Customer customer) {
        return customer.isDateInRange(START_DATE, END_DATE);
    }
}
