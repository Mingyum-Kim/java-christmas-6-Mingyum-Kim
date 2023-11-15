package christmas.domain.promotion;

import christmas.controller.dto.response.benefit.BenefitsResponse;
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

    public GiftsResponse toGiftsResponse() {

    }

    public BenefitsResponse toBenefitsResponse() {

    }

    public int calculatePayment(Orders orders) {

    }
}
