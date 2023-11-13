package christmas.view;

import christmas.controller.dto.response.OrdersResponse;
import christmas.view.console.ConsoleWriter;

public class OutputView {
    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    public void start() {
        ConsoleWriter.printlnMessage(START_MESSAGE);
    }

    public void printOrders(OrdersResponse ordersResponse) {

    }
}
