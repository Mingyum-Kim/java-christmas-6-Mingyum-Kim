package christmas.domain.restaurant;

import java.util.Arrays;
import java.util.List;

public enum Menu {
    APPETIZER(Arrays.asList(
            MenuItem.MUSHROOM_SOUP,
            MenuItem.TAPAS,
            MenuItem.CAESAR_SALAD)
    ),
    MAIN_COURSE(Arrays.asList(
            MenuItem.TBONE_STEAK,
            MenuItem.BARBECUE_RIBS,
            MenuItem.SEAFOOD_PASTA,
            MenuItem.CHRISTMAS_PASTA)
    ),
    DESSERT(Arrays.asList(
            MenuItem.CHOCOLATE_CAKE,
            MenuItem.ICE_CREAM)
    ),
    BEVERAGE(Arrays.asList(
            MenuItem.ZERO_COLA,
            MenuItem.RED_WINE,
            MenuItem.CHAMPAGNE)
    );

    private List<MenuItem> menuItems;

    Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
