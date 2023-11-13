package christmas.domain.restaurant;

public enum MenuItem {
    MUSHROOM_SOUP(6_000),
    TAPAS(5_500),
    CAESAR_SALAD(8_000),

    TBONE_STEAK(55_000),
    BARBECUE_RIBS(54_000),
    SEAFOOD_PASTA(35_000),
    CHRISTMAS_PASTA(25_000),

    CHOCOLATE_CAKE(15_000),
    ICE_CREAM(5_000),

    ZERO_COLA(3_000),
    RED_WINE(60_000),
    CHAMPAGNE(25_000);

    private int price;

    MenuItem(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
