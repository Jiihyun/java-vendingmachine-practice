package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_0(0),
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);
    public static final List<Coin> coinCategories = List.of(values());
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin from(int randomAmount) {
        return coinCategories.stream()
                .filter(coin -> coin.amount == randomAmount)
                .findFirst()
                .orElse(COIN_0);
    }

    public int getAmount() {
        return amount;
    }
}
