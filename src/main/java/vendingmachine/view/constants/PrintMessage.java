package vendingmachine.view.constants;

public enum PrintMessage {
    /*
    InputView
     */
    INPUT_VENDINGMACHINE_OWN_AMOUNT_MSG("자판기가 보유하고 있는 금액을 입력해 주세요."),
    INPUT_NAME_PRICE_QUANTITY_MSG("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_MONEY_AMOUNT_MSG("투입 금액을 입력해 주세요."),
    INPUT_NAME_OF_PRODUCT_MSG("구매할 상품명을 입력해 주세요."),
    /*
    OutputView
     */
    OUTPUT_COIN_QUANTITY_MSG(System.lineSeparator() + "자판기가 보유한 동전");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
