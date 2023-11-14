package christmas.controller.dto.response;

import christmas.domain.promotion.Gift;
import christmas.service.dto.response.PromotionResponse;
import christmas.service.dto.response.PromotionsResponse;
import java.util.List;

public record GiftsResponse(
        List<GiftResponse> responses
) {
    public static GiftsResponse from(PromotionsResponse promotionsResponse) {
        List<GiftResponse> giftResponses = toGiftResponses(promotionsResponse.responses());
        return new GiftsResponse(giftResponses);
    }

    private static List<GiftResponse> toGiftResponses(List<PromotionResponse> promotionResponses) {
        return promotionResponses.stream()
                .filter(response -> response.benefit() instanceof Gift)
                .map(response -> (Gift) response.benefit())
                .map(Gift::toGiftResponse)
                .toList();
    }
}
