package vendingmachine.validator;

import vendingmachine.exception.ExceptionMessage;

public class MoneyValidator {
    private MoneyValidator() {
        throw new AssertionError();
    }

    public static void validatePositive(int number) {
        if (number < 0) {
            throw ExceptionMessage.NUMBER_RANGE.getException();
        }
    }

    //TODO: 500, 100, 50, 10으로 나누어 떨어지는 지 확인 (도메인검증)
//    public static void validateRemainingValue(int number) {
//        if ()
//    }
}
