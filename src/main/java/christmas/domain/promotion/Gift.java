package christmas.domain.promotion;

import christmas.controller.dto.response.gift.GiftResponse;
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

    public GiftResponse toGiftResponse() {
        return new GiftResponse(
                this.menuItem.getName(),
                this.count.getValue()
        );
    }

    public int getPrice() {
        return this.menuItem.getCost() * this.count.getValue();
    }

    public boolean isNotEmpty() {
        return this.menuItem != MenuItem.NONE;
    }
}
