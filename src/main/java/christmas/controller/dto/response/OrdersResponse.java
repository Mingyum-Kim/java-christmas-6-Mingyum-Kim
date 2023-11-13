package christmas.controller.dto.response;

import java.util.List;

public record OrdersResponse(
        List<OrderResponse> orders
) {
}
