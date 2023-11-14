package christmas.controller.dto.response.benefit;

import christmas.service.dto.response.PromotionResponse;
import christmas.service.dto.response.PromotionsResponse;
import java.util.ArrayList;
import java.util.List;

public record BenefitsResponse(
        List<BenefitResponse> responses
) {
    public static BenefitsResponse from(PromotionsResponse promotionsResponse) {
        List<BenefitResponse> benefitResponses = new ArrayList<>();

        List<PromotionResponse> responses = promotionsResponse.responses();
        for (PromotionResponse response : responses) {
            BenefitResponse benefitResponse = BenefitResponse.of(
                    response.promotion(),
                    response.benefit()
            );
            benefitResponses.add(benefitResponse);
        }
        return new BenefitsResponse(benefitResponses);
    }
}
