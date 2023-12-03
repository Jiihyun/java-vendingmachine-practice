package vendingmachine.domain;

import vendingmachine.validator.ProductValidator;

import java.util.Comparator;
import java.util.List;

public class ProductInfos {
    private final List<ProductInfo> productInfos;

    public ProductInfos(List<ProductInfo> productInfos) {
        ProductValidator.validateDuplicatedName(productInfos);
        this.productInfos = productInfos;
    }

    public boolean hasProduct(String productName) {
        return productInfos.stream()
                .anyMatch(productInfo -> productInfo.findName(productName));
    }


    public int getProductQuantity(String productName) {
        return productInfos.stream()
                .filter(productInfo -> productInfo.findName(productName))
                .findFirst().get().getQuantity();
    }

    public int getProductPrice(String productName) {
        return productInfos.stream()
                .filter(productInfo -> productInfo.findName(productName))
                .findFirst().get().getPrice();
    }

    public int getProductOfLowestPrice() {
        return productInfos.stream()
                .map(ProductInfo::getPrice)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalStateException("No products found"));
    }

    public void minusQuantity(String productName) {
        productInfos.stream()
                .filter(productInfo -> productInfo.findName(productName))
                .findFirst().get().minusQuantity();
    }
}