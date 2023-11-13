package christmas.domain.customer;

import christmas.global.exception.CustomException;
import christmas.global.exception.ErrorMessage;

public class Date {
    private static final int START_DATE = 1;
    private static final int END_DATE = 31;

    private final int date;

    private Date(int date) {
        Validator.validate(date);
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public static Date from(int date) {
        return new Date(date);
    }

    private static class Validator {
        private static int validate(int date) {
            validateRange(date);
            return date;
        }

        private static void validateRange(int date) {
            if (isInvalidRange(date)) {
                throw CustomException.from(ErrorMessage.INVALID_DATE_ERROR);
            }
        }

        private static boolean isInvalidRange(int date) {
            return date < START_DATE || date > END_DATE;
        }
    }
}
