package christmas.domain.promotion;

import christmas.controller.dto.response.benefit.BenefitResponse;

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

    public BenefitResponse toBenefitResponse() {
        if (benefit instanceof Discount) {
            return new BenefitResponse(
                    promotion.getName(),
                    ((Discount) benefit).getPrice()
            );
        }
        return new BenefitResponse(
                promotion.getName(),
                ((Gift) benefit).getPrice()
        );
    }

    public boolean isInstanceOf(Class<?> clazz) {
        return clazz.isInstance(benefit);
    }

    public Gift getGift() {
        return (Gift) benefit;
    }

    public Discount getDiscount() {
        return (Discount) benefit;
    }
}
