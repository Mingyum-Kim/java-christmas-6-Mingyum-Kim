package christmas.service.promotion.gift;

import christmas.controller.dto.response.PromotionResponse;
import christmas.domain.customer.Count;
import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.Gift;
import christmas.domain.promotion.Promotion;
import christmas.domain.restaurant.MenuItem;
import christmas.service.promotion.PromotionService;

public class GiftPromotion implements PromotionService<PromotionResponse<Gift>> {
    private static final MenuItem GIFT_ITEM = MenuItem.CHAMPAGNE;
    private static final int GIFT_COUNT = 1;
    private static final int THRESHOLD = 120_000;

    @Override
    public PromotionResponse<Gift> apply(Date date, Orders orders) {
        if (isQualified(orders)) {
            return new PromotionResponse(
                    Promotion.GIFT,
                    Gift.of(GIFT_ITEM, Count.valueOf(GIFT_COUNT))
            );
        }
        return new PromotionResponse(
                Promotion.GIFT,
                Gift.of(MenuItem.NONE, Count.valueOf(0))
        );
    }

    private boolean isQualified(Orders orders) {
        return orders.calculateOrdersCost() >= THRESHOLD;
    }
}
