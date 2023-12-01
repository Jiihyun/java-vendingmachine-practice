package vendingmachine.validator;

import vendingmachine.exception.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {

    private InputValidator() {
        throw new AssertionError();
    }

    public static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw ExceptionMessage.INPUT_BLANK.getException();
        }
    }

     private static final String SEMICOLON_AND_COMMA_SEPARATED = "^\\[[ㄱ-힣]+,\\d+,\\d+](;\\[[ㄱ-힣]+,\\d+,\\d+])*$";

    public static void validateSemicolonAndCommaSeparatedRegex(String input) {
        InputValidator.validateBlank(input);
        if (!Pattern.matches(SEMICOLON_AND_COMMA_SEPARATED, input)) {
            throw ExceptionMessage.PATTERN_UNMATCHED.getException();
        }
    }
}
