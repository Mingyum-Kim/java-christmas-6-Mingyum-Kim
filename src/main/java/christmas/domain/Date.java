package christmas.domain;

public class Date {
    private final int date;

    private Date(int date) {
        this.date = date;
    }

    public static Date from(int date) {
        return new Date(date);
    }
}
