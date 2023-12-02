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

        if (hasSufficientMoney(paidMoney, productInfos) && enoughQuantity(productInfos, productName)) {
            paidMoney -= productInfos.getProductPrice(productName);
            productInfos.minusQuantity(productName);
        }
    }

    public int getPaidMoney() {
        return paidMoney;
    }

    private  boolean hasSufficientMoney(int paidMoney, ProductInfos productInfos) {
        return productInfos.getProductOfLowestPrice() <= paidMoney;
    }

    private boolean enoughQuantity(ProductInfos productInfos, String productName) {
        return productInfos.getProductQuantity(productName) >= 1;
    }
}
