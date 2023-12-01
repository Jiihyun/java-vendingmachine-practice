package vendingmachine.converter;

import vendingmachine.exception.ExceptionMessage;

import static vendingmachine.validator.InputValidator.validateBlank;

public class Converter {
    private Converter() {
        throw new AssertionError();
    }

    public static int convertToInt(String input) {
        try {
            validateBlank(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw ExceptionMessage.INPUT_NUMBER_FORMAT.getException();
        }
    }
}
