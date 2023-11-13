package christmas.view;

import christmas.controller.dto.response.CustomerResponse;
import christmas.view.console.ConsoleWriter;

public class OutputView {
    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String PROMOTION_NOTICE_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_NOTICE_MESSAGE = "\n<주문 메뉴>";
    private static final String ORDER_RESPONSE_MESSAGE = "%s %d개";
    private static final String TOTAL_COST_NOTICE_MESSAGE = "\n<할인 전 총주문 금액>";
    private static final String COST_MESSAGE = "%,d원";

    public void start() {
        ConsoleWriter.printlnMessage(START_MESSAGE);
    }

    public void printOrders(CustomerResponse customerResponse) {
        ConsoleWriter.printlnFormat(PROMOTION_NOTICE_MESSAGE, customerResponse.date());
        ConsoleWriter.printlnMessage(ORDER_NOTICE_MESSAGE);

        customerResponse.orders()
                .forEach(order -> ConsoleWriter.printlnFormat(
                        ORDER_RESPONSE_MESSAGE,
                        order.name(),
                        order.count())
                );
    }

    public void printTotalCost(final int totalCost) {
        ConsoleWriter.printlnMessage(TOTAL_COST_NOTICE_MESSAGE);
        ConsoleWriter.printlnFormat(COST_MESSAGE, totalCost);
    }
}
