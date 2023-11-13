package christmas.domain.customer;

import christmas.global.exception.CustomException;
import christmas.global.exception.ErrorMessage;

public class Count {
    private final int value;

    private Count(int value) {
        this.value = Validator.validate(value);
    }

    public static Count valueOf(int value) {
        return new Count(value);
    }

    public int getValue() {
        return value;
    }

    private static class Validator {
        private static int validate(int value) {
            validatePositive(value);
            return value;
        }

        private static void validatePositive(int value) {
            if (isNotPositive(value)) {
                throw CustomException.from(ErrorMessage.INVALID_ORDER_ERROR);
            }
        }

        private static boolean isNotPositive(int value) {
            return value < 1;
        }
    }
}
