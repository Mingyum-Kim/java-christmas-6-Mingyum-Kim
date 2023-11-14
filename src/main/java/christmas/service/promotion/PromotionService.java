package christmas.service.promotion;

import christmas.domain.customer.Customer;

public interface PromotionService<T> {
    public abstract T apply(Customer customer);
}
