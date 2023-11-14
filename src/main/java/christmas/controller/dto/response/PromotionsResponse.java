package christmas.controller.dto.response;

import christmas.domain.promotion.Benefit;
import java.util.List;

public record PromotionsResponse<T extends Benefit>(
        List<PromotionResponse<T>> responses
) {
}
