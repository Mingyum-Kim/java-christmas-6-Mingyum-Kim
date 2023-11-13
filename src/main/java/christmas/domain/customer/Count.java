package christmas.domain.customer;

import christmas.global.exception.CustomException;
import christmas.global.exception.ErrorMessage;

public class Count {
    private final int count;

    private Count(int count) {
        this.count = Validator.validate(count);
    }

    public static Count valueOf(int count) {
        return new Count(count);
    }

    private static class Validator {
        private static int validate(int count) {
            validatePositive(count);
            return count;
        }

        private static void validatePositive(int count) {
            if (isNotPositive(count)) {
                throw CustomException.from(ErrorMessage.INVALID_ORDER_ERROR);
            }
        }

        private static boolean isNotPositive(int count) {
            return count < 1;
        }
    }
}
