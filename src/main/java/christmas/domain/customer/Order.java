package christmas.domain.customer;

import christmas.controller.dto.response.order.OrderResponse;
import christmas.domain.restaurant.Menu;
import christmas.domain.restaurant.MenuItem;

public class Order {
    private MenuItem menuItem;
    private Count count;

    private Order(String name, int count) {
        this.menuItem = MenuItem.findByName(name);
        this.count = Count.valueOf(count);
    }

    public static Order of(String name, int count) {
        return new Order(name, count);
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public Count getCount() {
        return count;
    }

    public OrderResponse toResponse() {
        return new OrderResponse(menuItem.getName(), count.getValue());
    }

    public int calculateOrderCost() {
        return menuItem.getCost() * count.getValue();
    }

    public boolean isIncluded(Menu menu) {
        return Menu.contains(menu, menuItem);
    }

    public boolean isLessThan(int discountPrice) {
        return menuItem.getCost() < discountPrice;
    }

    public int calculateTotalPrice(int price) {
        return price * count.getValue();
    }
}
