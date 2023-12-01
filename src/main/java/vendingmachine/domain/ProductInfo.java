package vendingmachine.domain;

import vendingmachine.validator.PriceValidator;

public class ProductInfo {
    private final String name;
    private final int price;
    private final int quantity;

    public ProductInfo(String name, int price, int quantity) {
        PriceValidator.validatePrice(price);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean findName(String productName) {
        return name.equals(productName);
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}