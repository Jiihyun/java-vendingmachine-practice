package vendingmachine.validator;

import vendingmachine.domain.ProductInfo;
import vendingmachine.exception.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductValidator {
    private ProductValidator() {
        throw new AssertionError();
    }

    public static void validateDuplicatedName(List<ProductInfo> productInfos) {
        Set<String> productNames = new HashSet<>();
        for (ProductInfo productInfo : productInfos) {
            String name = productInfo.getName();
            if (!productNames.add(name)) {
                throw ExceptionMessage.DUPLICATED_PRODUCT_NAME.getException();
            }
        }
    }

    public static void validateProductQuantity(int quantity) {
        if (quantity < 1) {
            throw ExceptionMessage.INVALID_PRODUCT_QUANTITY.getException();
        }
    }
}
