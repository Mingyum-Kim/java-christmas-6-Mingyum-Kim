package christmas.domain.promotion;

public enum EventBadge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0);

    private final String name;
    private final int minAmount;

    EventBadge(String name, int minAmount) {
        this.name = name;
        this.minAmount = minAmount;
    }
}
