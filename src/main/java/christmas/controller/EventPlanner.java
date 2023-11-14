package christmas.controller;

import christmas.controller.dto.response.benefit.BenefitsResponse;
import christmas.controller.dto.response.gift.GiftsResponse;
import christmas.controller.dto.response.order.CustomerResponse;
import christmas.domain.customer.Date;
import christmas.domain.customer.Orders;
import christmas.domain.promotion.Discount;
import christmas.service.dto.response.PromotionResponse;
import christmas.service.dto.response.PromotionsResponse;
import christmas.service.promotion.PromotionHandler;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

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
                          PromotionsResponse promotionsResponse
    ) {
        outputView.printOrders(new CustomerResponse(date.getDate(), orders.toResponse()));
        outputView.printTotalCost(orders.calculateOrdersCost());

        outputView.printGiftMenu(GiftsResponse.from(promotionsResponse));
        outputView.printBenefits(BenefitsResponse.from(promotionsResponse));
        outputView.printCost(calculateCost(orders, promotionsResponse));
    }

    private int calculateCost(Orders orders, PromotionsResponse promotionsResponse) {
        return orders.calculateOrdersCost() - calculateDiscount(promotionsResponse.responses());
    }

    private int calculateDiscount(List<PromotionResponse> promotionResponses) {
        return promotionResponses.stream()
                .filter(response -> response.benefit() instanceof Discount)
                .mapToInt(response -> ((Discount) response.benefit()).getPrice())
                .sum();
    }
}
