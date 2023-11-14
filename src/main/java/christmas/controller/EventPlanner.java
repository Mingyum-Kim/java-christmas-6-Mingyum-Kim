package christmas.controller;

import christmas.controller.dto.request.OrdersRequest;
import christmas.controller.dto.response.CustomerResponse;
import christmas.controller.dto.response.GiftsResponse;
import christmas.domain.customer.Date;
import christmas.domain.customer.Order;
import christmas.domain.customer.Orders;
import christmas.service.dto.response.PromotionsResponse;
import christmas.service.promotion.PromotionHandler;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventPlanner {
    private final InputView inputView;
    private final OutputView outputView;
    private final PromotionHandler promotionHandler;

    public EventPlanner(InputView inputView, OutputView outputView, PromotionHandler promotionHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.promotionHandler = promotionHandler;
        outputView.start();
    }

    public void run() {
        Date date = Date.from(inputView.requestDate());
        Orders orders = Orders.from(convertOrders(inputView.requestOrders()));

        PromotionsResponse response = promotionHandler.process(date, orders);
        response(date, orders, response);
    }

    private List<Order> convertOrders(OrdersRequest ordersRequest) {
        return ordersRequest.orders()
                .stream()
                .map(order -> Order.of(order.name(), order.count()))
                .toList();
    }

    private void response(Date date, Orders orders, PromotionsResponse promotionsResponse) {
        outputView.printOrders(new CustomerResponse(date.getDate(), orders.toResponse()));
        outputView.printTotalCost(orders.calculateOrdersCost());

        outputView.printGiftMenu(GiftsResponse.from(promotionsResponse));
    }
}
