package christmas.view;

import christmas.global.exception.CustomException;
import christmas.global.exception.ErrorMessage;
import christmas.view.console.ConsoleReader;
import christmas.view.console.ConsoleWriter;

public class InputView {
    private static final String DATE_REQUEST_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public int requestDate() {
        ConsoleWriter.printlnMessage(DATE_REQUEST_MESSAGE);
        String date = ConsoleReader.enterMessage();
        return Validator.validateNumber(date);
    }

    private static class Validator {
        public static int validateNumber(String date) {
            try {
                return Integer.parseInt(date);
            } catch (NumberFormatException e) {
                throw CustomException.from(ErrorMessage.INVALID_DATE_ERROR);
            }
        }
    }
}
