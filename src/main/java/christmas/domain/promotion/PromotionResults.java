package christmas.domain.promotion;

import christmas.controller.dto.response.benefit.BenefitResponse;
import christmas.controller.dto.response.benefit.BenefitsResponse;
import christmas.controller.dto.response.gift.GiftResponse;
import christmas.controller.dto.response.gift.GiftsResponse;
import christmas.domain.customer.Orders;
import java.util.List;

public class PromotionResults {
    private List<PromotionResult> results;

    private PromotionResults(List<PromotionResult> results) {
        this.results = results;
    }

    public static PromotionResults from(List<PromotionResult> promotionResponses) {
        return new PromotionResults(promotionResponses);
    }

    public int calculatePayment(Orders orders) {
        return orders.calculateOrdersCost() - calculateDiscount();
    }

    private int calculateDiscount() {
        return results.stream()
                .filter(result -> result.isInstanceOf(Discount.class))
                .mapToInt(result -> result.getDiscount().getPrice())
                .sum();
    }

    public GiftsResponse toGiftsResponse() {
        List<GiftResponse> giftResponses = toGiftResponses();
        return new GiftsResponse(giftResponses);
    }

    private List<GiftResponse> toGiftResponses() {
        return results.stream()
                .filter(result -> result.isInstanceOf(Gift.class))
                .map(result -> result.getGift())
                .map(Gift::toGiftResponse)
                .toList();
    }

    public BenefitsResponse toBenefitsResponse() {
        List<BenefitResponse> benefitResponses = toBenefitResponses();
        return new BenefitsResponse(benefitResponses);
    }

    private List<BenefitResponse> toBenefitResponses() {
        return results.stream()
                .map(result -> result.toBenefitResponse())
                .toList();
    }
}
