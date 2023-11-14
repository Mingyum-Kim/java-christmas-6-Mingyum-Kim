package christmas.service.promotion;

import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.Discount;

public class WeekdayPromotion implements PromotionService<Discount> {
    private static final int DISCOUNT_PRICE_PER_MENU = 2_023;

    @Override
    public Discount apply(Date date, Orders orders) {
        if (isQualified(date)) {
            return Discount.from(calculateDiscountPrice(orders));
        }
        return Discount.from(0);
    }

    private int calculateDiscountPrice(Orders orders) {
        return orders.calculateTotalDiscountForDessertMenu(DISCOUNT_PRICE_PER_MENU);
    }

    private boolean isQualified(Date date) {
        return date.isWeekday();
    }
}
