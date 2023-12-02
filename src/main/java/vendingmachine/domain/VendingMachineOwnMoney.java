package vendingmachine.domain;

import vendingmachine.domain.dto.output.PossessCoinResponse;
import vendingmachine.validator.MoneyValidator;

import java.util.EnumMap;
import java.util.Map;

import static vendingmachine.domain.Coin.*;

public class VendingMachineOwnMoney {
    private int totalAmount;
    private final Map<Coin, Integer> possessQuantities;
    private final RandomCoinMaker randomCoinMaker;

    public VendingMachineOwnMoney(int totalAmount, Map<Coin, Integer> possessQuantities, RandomCoinMaker randomCoinMaker) {
        this.totalAmount = totalAmount;
        this.possessQuantities = possessQuantities;
        this.randomCoinMaker = randomCoinMaker;
    }

    private static Map<Coin, Integer> createStatistics() {
        Map<Coin, Integer> possessQuantity = new EnumMap<>(Coin.class);
        for (Coin coin : values()) {
            possessQuantity.put(coin, 0);
        }
        return possessQuantity;
    }

    public static VendingMachineOwnMoney from(int totalAmount) {
        MoneyValidator.validatePositive(totalAmount);
        return new VendingMachineOwnMoney(totalAmount, createStatistics(), new RandomCoinMaker());
    }

    public PossessCoinResponse getQuantities() {
        while (totalAmount > 0) {
            int coinAmount = randomCoinMaker.generate();
            if (totalAmount >= coinAmount) {
                Coin coin = Coin.from(coinAmount);
                possessQuantities.put(coin, possessQuantities.get(coin) + 1);
                totalAmount -= coinAmount;
            }
        }
        return new PossessCoinResponse(
                possessQuantities.get(COIN_500),
                possessQuantities.get(COIN_100),
                possessQuantities.get(COIN_50),
                possessQuantities.get(COIN_10));
    }

    public Map<Coin, Integer> getPossessQuantities() {
        return possessQuantities;
    }
}
