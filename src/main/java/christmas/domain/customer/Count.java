package christmas.domain.customer;

public class Count {
    private final int count;

    private Count(int count) {
        this.count = count;
    }

    public static Count from(int count) {
        return new Count(count);
    }
}
