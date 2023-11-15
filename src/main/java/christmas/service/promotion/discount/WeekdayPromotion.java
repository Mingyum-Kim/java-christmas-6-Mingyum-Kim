package christmas.service.promotion.discount;

import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.Discount;
import christmas.domain.promotion.Promotion;
import christmas.domain.promotion.PromotionResult;
import christmas.domain.restaurant.Menu;
import christmas.service.promotion.PromotionService;

public class WeekdayPromotion implements PromotionService<PromotionResult<Discount>> {
    private static final int DISCOUNT_PRICE_PER_MENU = 2_023;

    @Override
    public PromotionResult<Discount> apply(Date date, Orders orders) {
        if (isQualified(date)) {
            return PromotionResult.of(
                    Promotion.WEEKDAY,
                    Discount.from(calculateDiscount(orders))
            );
        }
        return PromotionResult.of(
                Promotion.WEEKDAY,
                Discount.from(0)
        );
    }

    private boolean isQualified(Date date) {
        return date.isWeekday();
    }

    /**
     * 디저트 메뉴 하나 당 할인 금액을 적용하는 메서드
     *
     * @param orders 주문 내역
     * @return 모든 디저트 메뉴에 대한 총 할인 금액
     */
    private int calculateDiscount(Orders orders) {
        return orders.calculateTotalDiscountForMenu(DISCOUNT_PRICE_PER_MENU, Menu.DESSERT);
    }
}
