package christmas.domain.promotion;

public class Discount {
    private final int price;

    private Discount(int price) {
        this.price = price;
    }

    public static Discount from(int price) {
        return new Discount(price);
    }
}
