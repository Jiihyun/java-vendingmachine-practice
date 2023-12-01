package vendingmachine.exception;

public enum ExceptionMessage {
    INPUT_BLANK("입력값이 공백입니다."),
    INPUT_NUMBER_FORMAT("숫자만 입력해주세요."),
    NUMBER_RANGE("양수만 입력 가능합니다.");
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = PREFIX + message;
    }

    public ProgramException getException() {
        return new ProgramException(this.message);
    }
}
