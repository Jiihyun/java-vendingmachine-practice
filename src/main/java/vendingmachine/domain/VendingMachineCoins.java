package vendingmachine.domain;

import vendingmachine.domain.dto.output.CoinQuantitiesResponse;
import vendingmachine.validator.MoneyValidator;

import java.util.EnumMap;
import java.util.Map;

import static vendingmachine.domain.Coin.*;

public class VendingMachineCoins {
    private int totalAmount;
    private final Map<Coin, Integer> coinQuantities;
    private final RandomCoinMaker randomCoinMaker;

    public VendingMachineCoins(int totalAmount, Map<Coin, Integer> coinQuantities, RandomCoinMaker randomCoinMaker) {
        this.totalAmount = totalAmount;
        this.coinQuantities = coinQuantities;
        this.randomCoinMaker = randomCoinMaker;
    }

    private static Map<Coin, Integer> createStatistics() {
        Map<Coin, Integer> coinQuantities = new EnumMap<>(Coin.class);
        for (Coin coin : values()) {
            coinQuantities.put(coin, 0);
        }
        return coinQuantities;
    }

    public static VendingMachineCoins from(int totalAmount) {
        MoneyValidator.validatePositive(totalAmount);
        return new VendingMachineCoins(totalAmount, createStatistics(), new RandomCoinMaker());
    }

    public CoinQuantitiesResponse toCoinQuantities() {
        updateCoinQuantities();
        return new CoinQuantitiesResponse(
                coinQuantities.get(COIN_500),
                coinQuantities.get(COIN_100),
                coinQuantities.get(COIN_50),
                coinQuantities.get(COIN_10));
    }

    public void updateCoinQuantities() {
        while (totalAmount > 0) {
            Coin randomCoin = randomCoinMaker.generate();
            int randomCoinAmount = randomCoin.getAmount();

            addCoinQuantities(randomCoin, randomCoinAmount);
        }
    }

    public Map<Coin, Integer> getCoinQuantities() {
        return coinQuantities;
    }

    private void addCoinQuantities(Coin randomCoin, int randomCoinAmount) {
        if (totalAmount >= randomCoinAmount) {
            coinQuantities.put(randomCoin, coinQuantities.get(randomCoin) + 1);
            totalAmount -= randomCoinAmount;
        }
    }
}
