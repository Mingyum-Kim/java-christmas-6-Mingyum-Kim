package christmas.domain.customer;

import christmas.controller.dto.response.CustomerResponse;

public class Customer {
    private Date date;
    private Orders orders;

    private Customer(Date date, Orders orders) {
        this.date = date;
        this.orders = orders;
    }

    public static Customer of(Date date, Orders orders) {
        return new Customer(date, orders);
    }

    public CustomerResponse toResponse() {
        return new CustomerResponse(date.getDate(), orders.toResponse());
    }

    public int calculateTotalCost() {
        return orders.calculateTotalCost();
    }
}
