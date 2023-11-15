package christmas.view;

import christmas.controller.dto.response.benefit.BenefitsResponse;
import christmas.controller.dto.response.gift.GiftsResponse;
import christmas.controller.dto.response.order.CustomerResponse;
import christmas.domain.promotion.EventBadge;
import christmas.view.console.ConsoleWriter;

public class OutputView {
    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String PROMOTION_NOTICE_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_NOTICE_MESSAGE = "\n<주문 메뉴>";
    private static final String MENU_RESPONSE_MESSAGE = "%s %d개";
    private static final String TOTAL_COST_NOTICE_MESSAGE = "\n<할인 전 총주문 금액>";
    private static final String COST_MESSAGE = "%,d원";
    private static final String GIFT_MENU_NOTICE_MESSAGE = "\n<증정 메뉴>";
    private static final String NONE = "없음";
    private static final String BENEFIT_NOTICE_MESSAGE = "\n<혜택 내역>";
    private static final String BENEFIT_RESPONSE_MESSAGE = "%s: -%,d원";
    private static final String TOTAL_BENEFIT_NOTICE_MESSAGE = "총혜택 금액";

    public void start() {
        ConsoleWriter.printlnMessage(START_MESSAGE);
    }

    public void printOrders(CustomerResponse customerResponse) {
        ConsoleWriter.printlnFormat(PROMOTION_NOTICE_MESSAGE, customerResponse.date());
        ConsoleWriter.printlnMessage(ORDER_NOTICE_MESSAGE);

        customerResponse.orders()
                .forEach(order -> ConsoleWriter.printlnFormat(
                        MENU_RESPONSE_MESSAGE,
                        order.name(),
                        order.count())
                );
    }

    public void printTotalCost(final int totalCost) {
        ConsoleWriter.printlnMessage(TOTAL_COST_NOTICE_MESSAGE);
        ConsoleWriter.printlnFormat(COST_MESSAGE, totalCost);
    }

    public void printGiftMenu(GiftsResponse giftsResponse) {
        ConsoleWriter.printlnMessage(GIFT_MENU_NOTICE_MESSAGE);

        if (giftsResponse.responses().isEmpty()) {
            ConsoleWriter.printlnMessage(NONE);
            return;
        }
        giftsResponse.responses()
                .forEach(response -> printGiftMenu(
                        response.name(),
                        response.count())
                );
    }

    private void printGiftMenu(final String name, final int count) {
        ConsoleWriter.printlnFormat(GIFT_MENU_NOTICE_MESSAGE, name, count);
    }

    public void printBenefits(BenefitsResponse benefitsResponse) {
        ConsoleWriter.printlnMessage(BENEFIT_NOTICE_MESSAGE);

        if (benefitsResponse.responses().isEmpty()) {
            ConsoleWriter.printlnMessage(NONE);
            return;
        }
        benefitsResponse.responses()
                .forEach(response -> printBenefit(
                        response.promotion(),
                        response.price())
                );
    }

    private void printBenefit(final String promotion, final int price) {
        ConsoleWriter.printlnFormat(BENEFIT_RESPONSE_MESSAGE, promotion, price);
    }

    public void printTotalBenefits(final int benefits) {
        ConsoleWriter.printlnMessage(TOTAL_BENEFIT_NOTICE_MESSAGE);
        ConsoleWriter.printlnFormat(COST_MESSAGE, benefits);
    }

    public void printCost(final int cost) {
        ConsoleWriter.printlnFormat(COST_MESSAGE, cost);
    }

    public void printEventBadge(EventBadge eventBadge) {
        ConsoleWriter.printlnMessage(eventBadge.getName());
    }
}
