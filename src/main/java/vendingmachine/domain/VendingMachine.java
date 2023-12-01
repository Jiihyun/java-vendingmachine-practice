package vendingmachine.domain;

import vendingmachine.validator.BuyingValidator;
import vendingmachine.validator.MoneyValidator;

import java.util.List;

public class VendingMachine {
    private final ProductInfos productInfos;
    private int paidMoney;

    private VendingMachine(ProductInfos productInfos, int paidMoney) {
        this.productInfos = productInfos;
        this.paidMoney = paidMoney;
    }

    public static VendingMachine of(ProductInfos productInfos, int paidMoney) {
        MoneyValidator.validatePositive(paidMoney);
        return new VendingMachine(productInfos, paidMoney);
    }

    public void buyProduct(String productName) {
        BuyingValidator.validateIfProductExist(productInfos, productName);

    }
}
