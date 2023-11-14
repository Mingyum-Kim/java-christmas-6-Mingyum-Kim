package christmas.service.promotion.gift;

import christmas.domain.customer.Count;
import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.Gift;
import christmas.domain.restaurant.MenuItem;
import christmas.service.promotion.PromotionService;

public class GiftPromotion implements PromotionService<Gift> {
    private static final MenuItem GIFT_ITEM = MenuItem.CHAMPAGNE;
    private static final int GIFT_COUNT = 1;
    private static final int THRESHOLD = 120_000;

    @Override
    public Gift apply(Date date, Orders orders) {
        if (isQualified(orders)) {
            return Gift.of(GIFT_ITEM, Count.valueOf(GIFT_COUNT));
        }
        return Gift.of(MenuItem.NONE, Count.valueOf(0));
    }

    private boolean isQualified(Orders orders) {
        return orders.calculateOrdersCost() >= THRESHOLD;
    }
}
