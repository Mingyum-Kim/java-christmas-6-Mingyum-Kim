package christmas.domain.promotion;

public class PromotionResult<T extends Benefit> {
    private Promotion promotion;
    private T benefit;

    private PromotionResult(Promotion promotion, T benefit) {
        this.promotion = promotion;
        this.benefit = benefit;
    }

    public static PromotionResult of(Promotion promotion, Benefit benefit) {
        return new PromotionResult(promotion, benefit);
    }
}
