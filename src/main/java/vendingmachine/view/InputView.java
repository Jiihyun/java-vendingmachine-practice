package vendingmachine.view;

import vendingmachine.converter.Converter;
import vendingmachine.domain.VendingMachineOwnMoney;
import vendingmachine.io.reader.Reader;
import vendingmachine.io.writer.Writer;

import static vendingmachine.view.constants.PrintMessage.INPUT_VENDINGMACHINE_OWN_AMOUNT_MSG;

public class InputView {
    private final Writer writer;
    private final Reader reader;

    public InputView(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public VendingMachineOwnMoney getMoneyInVendingMachine() {
        writer.writeln(INPUT_VENDINGMACHINE_OWN_AMOUNT_MSG.getMessage());
        int totalAmount = Converter.convertToInt(reader.readLine());
        return VendingMachineOwnMoney.from(totalAmount);
    }
}
