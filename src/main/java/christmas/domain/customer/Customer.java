package christmas.domain.customer;

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
}
