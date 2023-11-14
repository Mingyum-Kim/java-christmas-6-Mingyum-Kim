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
import java.util.Arrays;
import java.util.List;

public class PromotionHandler {
    public PromotionsResponse process(Date date, Orders orders) {
        List<PromotionService<?>> promotionServices = register();

        List<PromotionResponse> promotionResponses = generateResponses(date, orders, promotionServices);
        return new PromotionsResponse(promotionResponses);
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
