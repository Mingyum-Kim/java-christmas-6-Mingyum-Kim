package christmas.controller.dto.response;

import java.util.List;

public record BenefitsResponse(
        List<BenefitResponse> responses
) {
}
