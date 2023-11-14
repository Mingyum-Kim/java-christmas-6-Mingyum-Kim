package christmas.controller;

import christmas.controller.dto.request.OrdersRequest;
import christmas.controller.dto.response.CustomerResponse;
import christmas.domain.customer.Date;
import christmas.domain.customer.Order;
import christmas.domain.customer.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventPlanner {
    private final InputView inputView;
    private final OutputView outputView;

    public EventPlanner(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        outputView.start();
    }

    public void run() {
        Date date = Date.from(inputView.requestDate());
        Orders orders = Orders.from(convertToOrders(inputView.requestOrders()));
        response(date, orders);
    }

    private List<Order> convertToOrders(OrdersRequest ordersRequest) {
        return ordersRequest.orders()
                .stream()
                .map(order -> Order.of(order.name(), order.count()))
                .toList();
    }

    private void response(Date date, Orders orders) {
        outputView.printOrders(new CustomerResponse(date.getDate(), orders.toResponse()));
        outputView.printTotalCost(orders.calculateTotalCost());
    }
}
