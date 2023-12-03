package vendingmachine.exception;

public enum ExceptionMessage {
    INPUT_BLANK("입력값이 공백입니다."),
    INPUT_NUMBER_FORMAT("숫자만 입력해주세요."),
    NUMBER_RANGE("양수만 입력 가능합니다."),
    PATTERN_UNMATCHED("잘못된 입력 형식입니다."),
    PRICE_MINIMUM_AMOUNT("가격은 최소 100원 이상이어야 합니다"),
    PRICE_UNIT("10원 단위로 입력해 주세요."),
    NONEXIST_PRODUCT("존재하지 않는 상품입니다."),
    DUPLICATED_PRODUCT_NAME("중복된 상품이 존재합니다."),
    INVALID_PRODUCT_QUANTITY("1개 이상의 수량을 입력해 주세요.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = PREFIX + message;
    }

    public ProgramException getException() {
        return new ProgramException(this.message);
    }
}
