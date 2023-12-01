package vendingmachine.view;

import vendingmachine.converter.Converter;
import vendingmachine.domain.ProductInfo;
import vendingmachine.domain.VendingMachineOwnMoney;
import vendingmachine.io.reader.Reader;
import vendingmachine.io.writer.Writer;

import java.util.List;

import static vendingmachine.view.constants.PrintMessage.INPUT_NAME_PRICE_QUANTITY_MSG;
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

    public List<ProductInfo> getProductInfo() {
        writer.writeln(INPUT_NAME_PRICE_QUANTITY_MSG.getMessage());
        return Converter.convertToTriple(reader.readLine());
    }
}
