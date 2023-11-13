package christmas.controller;

import christmas.controller.dto.request.OrdersRequest;
import christmas.domain.Date;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    private final InputView inputView;
    private final OutputView outputView;

    EventPlanner(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        outputView.start();
    }

    public void run() {
        Date date = Date.from(inputView.requestDate());
        OrdersRequest ordersRequest = inputView.requestOrders();
    }
}
