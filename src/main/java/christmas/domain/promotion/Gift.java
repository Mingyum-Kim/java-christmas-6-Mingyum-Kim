package christmas.domain.promotion;

import christmas.controller.dto.response.GiftResponse;
import christmas.domain.customer.Count;
import christmas.domain.restaurant.MenuItem;

public class Gift extends Benefit {
    private MenuItem menuItem;
    private Count count;

    private Gift(MenuItem menuItem, Count count) {
        this.menuItem = menuItem;
        this.count = count;
    }

    public static Gift of(MenuItem menuItem, Count count) {
        return new Gift(menuItem, count);
    }

    public GiftResponse toResponse() {
        return new GiftResponse(
                this.menuItem.getName(),
                this.count.getValue()
        );
    }
}
