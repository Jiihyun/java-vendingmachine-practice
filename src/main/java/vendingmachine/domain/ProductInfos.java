package vendingmachine.domain;

import vendingmachine.validator.ProductValidator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
                .collect(Collectors.toMap(ProductInfo::getName, ProductInfo::getPrice, Integer::min))
                .values()
                .stream()
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalStateException("No products found"));
    }

    public void minusQuantity(String productName) {
        productInfos.stream()
                .filter(productInfo -> productInfo.findName(productName))
                .findFirst().get().minusQuantity();
    }
}