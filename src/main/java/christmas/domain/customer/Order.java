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

    /**
     * 특정 메뉴 카테고리에 해당하는 주문임을 확인하는 메서드
     *
     * @param menu 메뉴 카테고리
     * @return 주문 메뉴가 메뉴 카테고리와 일치하면 true, 그렇지 않으면 false
     */
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
