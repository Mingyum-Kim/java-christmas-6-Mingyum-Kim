package christmas.view;

import christmas.global.exception.CustomException;
import christmas.global.exception.ErrorMessage;
import christmas.view.console.ConsoleReader;
import christmas.view.console.ConsoleWriter;

public class InputView {
    private static final String DATE_REQUEST_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDERS_REQUEST_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public int requestDate() {
        ConsoleWriter.printlnMessage(DATE_REQUEST_MESSAGE);
        String date = ConsoleReader.enterMessage();
        return Validator.validateNumber(date);
    }

    public void requestOrders() {
        ConsoleWriter.printlnMessage(ORDERS_REQUEST_MESSAGE);
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
