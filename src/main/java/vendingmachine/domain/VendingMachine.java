package vendingmachine.domain;

import vendingmachine.validator.BuyingValidator;
import vendingmachine.validator.MoneyValidator;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class VendingMachine {
    private final ProductInfos productInfos;
    private int remainMoney;

    private VendingMachine(ProductInfos productInfos, int remainMoney) {
        this.productInfos = productInfos;
        this.remainMoney = remainMoney;
    }

    public static VendingMachine of(ProductInfos productInfos, int paidMoney) {
        MoneyValidator.validatePositive(paidMoney);
        return new VendingMachine(productInfos, paidMoney);
    }

    public void buyProduct(String productName) {
        BuyingValidator.validateIfProductExist(productInfos, productName);

        if (hasSufficientMoney(remainMoney, productInfos) && enoughQuantity(productInfos, productName)) {
            remainMoney -= productInfos.getProductPrice(productName);
            productInfos.minusQuantity(productName);
        }
    }

    public int getRemainMoney() {
        return remainMoney;
    }

    private boolean hasSufficientMoney(int paidMoney, ProductInfos productInfos) {
        return productInfos.getProductOfLowestPrice() <= paidMoney;
    }

    private boolean enoughQuantity(ProductInfos productInfos, String productName) {
        return productInfos.getProductQuantity(productName) >= 1;
    }

    public Map<Coin, Integer> returnChange(VendingMachineCoins moneyInVendingMachine, int remainMoney) {
        Map<Coin, Integer> change = new EnumMap<>(Coin.class);
        Map<Coin, Integer> possessQuantities = moneyInVendingMachine.getPossessQuantities();
        Map<Coin, Integer> changeQuantity = possessQuantities.entrySet().stream().filter(coinIntegerEntry -> coinIntegerEntry.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Coin coin : changeQuantity.keySet()) {
            int coinAmount = coin.getAmount();
            int availableCoins = possessQuantities.getOrDefault(coin, 0);

            int count = Math.min(remainMoney / coinAmount, availableCoins);

            if (count > 0) {
                change.put(coin, count);
                remainMoney -= count * coinAmount;
            }
        }
        return change;
    }
}
