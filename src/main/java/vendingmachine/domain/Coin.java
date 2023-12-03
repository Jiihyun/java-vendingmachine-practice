package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public enum Coin {
    COIN_0(0),
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);
    // imp: 미리 객체를 생성하여 성능 개선시키기
    private static final Map<Integer, Coin> cachedCoin = new HashMap<>();

    static {
        for (Coin coin : values()) {
            cachedCoin.put(coin.amount, coin);
        }
    }

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin from(int randomAmount) {
        return cachedCoin.get(randomAmount);
    }

    public int getAmount() {
        return amount;
    }
}
