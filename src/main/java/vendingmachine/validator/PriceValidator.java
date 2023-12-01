package vendingmachine.validator;

import vendingmachine.exception.ExceptionMessage;

public class PriceValidator {
    private static final int MINIMUM_AMOUNT = 100;
    private static final int PRICE_UNIT = 10;
    private PriceValidator() {
        throw new AssertionError();
    }

    public static void validatePrice(int price) {
        validateMinimumAmount(price);
        validatePriceUnit(price);
    }
    private static void validateMinimumAmount(int price) {
        if (price < MINIMUM_AMOUNT) {
            throw ExceptionMessage.PRICE_MINIMUM_AMOUNT.getException();
        }
    }

    private static void validatePriceUnit(int price) {
        if (price % PRICE_UNIT != 0) {
            throw ExceptionMessage.PRICE_UNIT.getException();
        }
    }
}
