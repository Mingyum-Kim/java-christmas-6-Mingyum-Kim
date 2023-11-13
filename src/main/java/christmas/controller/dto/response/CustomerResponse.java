package christmas.controller.dto.response;

import java.util.List;

public record CustomerResponse(
        int date,
        List<OrderResponse> orders
) {
}
