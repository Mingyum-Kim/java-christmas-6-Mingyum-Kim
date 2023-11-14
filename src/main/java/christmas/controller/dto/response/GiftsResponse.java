package christmas.controller.dto.response;

import java.util.List;

public record GiftsResponse(
        List<GiftResponse> responses
) {
}
