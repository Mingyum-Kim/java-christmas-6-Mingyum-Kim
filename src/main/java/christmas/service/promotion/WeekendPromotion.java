package christmas.service.promotion;

import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.Discount;

public class WeekendPromotion implements PromotionService<Discount> {
    @Override
    public Discount apply(Date date, Orders orders) {
        if (isQualified(date)) {
            
        }
    }

    private boolean isQualified(Date date) {
        return date.isWeekend();
    }
}
