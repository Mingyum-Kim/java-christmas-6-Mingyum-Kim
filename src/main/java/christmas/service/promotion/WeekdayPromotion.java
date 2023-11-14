package christmas.service.promotion;

import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.Discount;

public class WeekdayPromotion implements PromotionService<Discount> {
    @Override
    public Discount apply(Date date, Orders orders) {

    }

    private boolean isQualified(Date date) {
        return date.isWeekday();
    }
}
