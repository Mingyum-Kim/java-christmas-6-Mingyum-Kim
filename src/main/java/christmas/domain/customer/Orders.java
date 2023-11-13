package christmas.domain.customer;

import christmas.global.exception.CustomException;
import christmas.global.exception.ErrorMessage;
import java.util.List;

public class Orders {
    private List<Order> orders;

    private Orders(List<Order> orders) {
        this.orders = Validator.validate(orders);
    }

    public static Orders from(List<Order> orders) {
        return new Orders(orders);
    }

    private static class Validator {
        private static List<Order> validate(List<Order> orders) {
            validateDuplicatedMenuItems(orders);
        }

        private static void validateDuplicatedMenuItems(List<Order> orders) {
            if (hasDuplicatedMenuItems(orders)) {
                throw CustomException.from(ErrorMessage.INVALID_ORDER_ERROR);
            }
        }

        private static boolean hasDuplicatedMenuItems(List<Order> orders) {
            return orders.size() != calculateUniqueMenuItems(orders);
        }

        private static int calculateUniqueMenuItems(List<Order> orders) {
            return (int) orders.stream()
                    .map(Order::getMenuItem)
                    .distinct()
                    .count();
        }
    }
}
