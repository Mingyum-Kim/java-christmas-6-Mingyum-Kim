package christmas.controller;

import christmas.controller.dto.response.order.CustomerResponse;
import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.PromotionResults;
import christmas.service.promotion.PromotionHandler;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    private final InputView inputView;
    private final OutputView outputView;
    private final PromotionHandler promotionHandler;

    public EventPlanner(InputView inputView,
                        OutputView outputView,
                        PromotionHandler promotionHandler
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.promotionHandler = promotionHandler;
        outputView.start();
    }

    public void run() {
        Date date = Date.from(inputView.requestDate());
        Orders orders = Orders.from(inputView.requestOrders());

        response(date, orders, promotionHandler.process(date, orders));
    }


    private void response(Date date,
                          Orders orders,
                          PromotionResults promotionResults
    ) {
        outputView.printOrders(new CustomerResponse(date.getDate(), orders.toResponse()));
        outputView.printTotalCost(orders.calculateOrdersCost());

        outputView.printGiftMenu(promotionResults.toGiftsResponse());
        outputView.printBenefits(promotionResults.toBenefitsResponse());
        outputView.printCost(promotionResults.calculatePayment(orders));
    }
}
