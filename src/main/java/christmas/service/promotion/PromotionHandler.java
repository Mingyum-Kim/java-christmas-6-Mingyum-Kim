package christmas.service.promotion;

import christmas.controller.dto.response.PromotionResponse;
import christmas.controller.dto.response.PromotionsResponse;
import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.service.promotion.discount.ChristmasPromotion;
import christmas.service.promotion.discount.SpecialPromotion;
import christmas.service.promotion.discount.WeekdayPromotion;
import christmas.service.promotion.discount.WeekendPromotion;
import christmas.service.promotion.gift.GiftPromotion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PromotionHandler {
    private static final int THRESHOLD = 10_000;

    public PromotionsResponse process(Date date, Orders orders) {
        if (isQualified(orders)) {
            List<PromotionService<?>> promotionServices = register();

            List<PromotionResponse> promotionResponses = generateResponses(date, orders, promotionServices);
            return new PromotionsResponse(promotionResponses);
        }
        return new PromotionsResponse(new ArrayList<>());
    }

    private boolean isQualified(Orders orders) {
        return orders.calculateOrdersCost() >= THRESHOLD;
    }

    private List<PromotionResponse> generateResponses(Date date, Orders orders,
                                                      List<PromotionService<?>> promotionServices) {
        return promotionServices.stream()
                .map(promotionService -> (PromotionResponse) promotionService.apply(date, orders))
                .toList();
    }

    private List<PromotionService<?>> register() {
        return Arrays.asList(
                new ChristmasPromotion(),
                new WeekdayPromotion(),
                new WeekendPromotion(),
                new SpecialPromotion(),
                new GiftPromotion()
        );
    }
}
