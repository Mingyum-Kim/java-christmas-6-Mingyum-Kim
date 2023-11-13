package christmas.domain.customer;

import christmas.domain.restaurant.MenuItem;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(menuItem, order.menuItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuItem);
    }
}
