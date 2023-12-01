package vendingmachine.view.constants;

public enum PrintFormat {
    QUANTITY_FORMAT("500원 - %d개" + System.lineSeparator() +
            "100원 - %d개" + System.lineSeparator() +
            "50원 - %d개" + System.lineSeparator() +
            "10원 - %d개" + System.lineSeparator()),
    ;
    private final String format;

    PrintFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
