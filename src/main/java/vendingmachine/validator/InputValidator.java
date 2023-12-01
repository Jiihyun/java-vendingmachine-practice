package vendingmachine.validator;

import vendingmachine.exception.ExceptionMessage;

public class InputValidator {

    private InputValidator() {
        throw new AssertionError();
    }

    public static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw ExceptionMessage.INPUT_BLANK.getException();
        }
    }
}
