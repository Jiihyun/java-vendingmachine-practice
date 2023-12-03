package vendingmachine.converter;

import vendingmachine.domain.ProductInfo;
import vendingmachine.exception.ExceptionMessage;
import vendingmachine.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

import static vendingmachine.validator.InputValidator.validateBlank;

public class Converter {
    private static final String PRODUCT_DELIMITER = ";";
    private static final String INFO_DELIMITER = ",";

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

    public static List<ProductInfo> convertToTriple(String input) {
        InputValidator.validateSemicolonAndCommaSeparatedRegex(input);
        final String[] seperatedBySemicolon = replaceSquareBracketsFrom(input)
                .split(PRODUCT_DELIMITER);

        return Arrays.stream(seperatedBySemicolon)
                .map(str -> {
                    String[] values = str.split(INFO_DELIMITER);

                    return new ProductInfo(values[0],
                            convertToInt(values[1]),
                            convertToInt(values[2]));
                })
                .toList();
    }

    private static String replaceSquareBracketsFrom(String input) {
        return input.replaceAll("\\[", "")
                .replaceAll("]", "");
    }
}
