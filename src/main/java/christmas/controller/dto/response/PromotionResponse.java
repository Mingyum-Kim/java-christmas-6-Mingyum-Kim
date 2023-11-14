package christmas.controller.dto.response;

import christmas.domain.promotion.Benefit;
import christmas.domain.promotion.Promotion;

public record PromotionResponse<T extends Benefit>(
        Promotion promotion,
        T benefit
) {
}
