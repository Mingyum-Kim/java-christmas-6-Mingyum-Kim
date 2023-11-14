package christmas.controller.dto.response.benefit;

import christmas.domain.promotion.Benefit;
import christmas.domain.promotion.Discount;
import christmas.domain.promotion.Gift;
import christmas.domain.promotion.Promotion;

public record BenefitResponse(
        String promotion,
        int price
) {
    public static BenefitResponse of(Promotion promotion, Benefit benefit) {
        if (benefit instanceof Discount) {
            return new BenefitResponse(
                    promotion.getName(),
                    cast(benefit, Discount.class).getPrice()
            );
        }
        return new BenefitResponse(
                promotion.getName(),
                cast(benefit, Gift.class).getPrice()
        );
    }

    private static <T> T cast(Benefit benefit, Class<T> clazz) {
        return clazz.cast(benefit);
    }
}
