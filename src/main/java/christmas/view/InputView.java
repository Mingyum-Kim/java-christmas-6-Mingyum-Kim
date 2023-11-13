package christmas.view;

import christmas.view.console.ConsoleReader;
import christmas.view.console.ConsoleWriter;

public class InputView {
    private static final String DATE_REQUEST_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public void requestDate() {
        ConsoleWriter.printlnMessage(DATE_REQUEST_MESSAGE);
        ConsoleReader.enterMessage();
    }
}
