package vendingmachine.validator;

import vendingmachine.domain.ProductInfos;
import vendingmachine.exception.ExceptionMessage;

public class BuyingValidator {
    private BuyingValidator() {
        throw new AssertionError();
    }

    public static void validateIfProductExist(ProductInfos productInfos, String productName) {
        if (!productInfos.hasProduct(productName)) {
            throw ExceptionMessage.NONEXIST_PRODUCT.getException();
        }
    }
}