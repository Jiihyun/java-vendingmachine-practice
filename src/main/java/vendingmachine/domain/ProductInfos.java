package vendingmachine.domain;

import java.util.List;

public class ProductInfos {
    private final List<ProductInfo> productInfos;

    public ProductInfos(List<ProductInfo> productInfos) {
        this.productInfos = productInfos;
    }

    public boolean hasProduct(String productName) {
        return productInfos.stream()
                .anyMatch(productInfo -> productInfo.findName(productName));
    }
}