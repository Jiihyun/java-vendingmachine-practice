package vendingmachine.domain;

import vendingmachine.validator.PriceValidator;
import vendingmachine.validator.ProductValidator;

public class ProductInfo {
    private final String name;
    private final int price;
    private int quantity;

    public ProductInfo(String name, int price, int quantity) {
        PriceValidator.validatePrice(price);
        ProductValidator.validateProductQuantity(quantity);
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

    public void minusQuantity() {
        quantity--;
    }
}