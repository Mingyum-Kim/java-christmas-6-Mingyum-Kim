package christmas.service.promotion;

import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.PromotionResult;
import christmas.domain.promotion.PromotionResults;
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

    /**
     * 모든 이벤트를 적용하고 혜택 내역을 생성하는 메서드
     *
     * @param date   방문할 날짜
     * @param orders 주문 내역
     * @return
     */
    public PromotionResults process(Date date, Orders orders) {
        if (isQualified(orders)) {
            List<PromotionService<?>> promotionServices = register();

            List<PromotionResult> promotionResponses = generateResponses(date, orders, promotionServices);
            return PromotionResults.from(promotionResponses);
        }
        return PromotionResults.from(new ArrayList<>());
    }

    private boolean isQualified(Orders orders) {
        return orders.calculateOrdersCost() >= THRESHOLD;
    }

    private List<PromotionResult> generateResponses(Date date, Orders orders,
                                                    List<PromotionService<?>> promotionServices) {
        return promotionServices.stream()
                .map(promotionService -> (PromotionResult) promotionService.apply(date, orders))
                .toList();
    }

    /**
     * 모든 이벤트의 구현 클래스를 등록하는 메서드
     *
     * @return 인터페이스의 구현 클래스의 리스트
     */
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
