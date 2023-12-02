package vendingmachine.view;

import vendingmachine.converter.Converter;
import vendingmachine.domain.ProductInfo;
import vendingmachine.domain.ProductInfos;
import vendingmachine.domain.VendingMachineOwnMoney;
import vendingmachine.io.reader.Reader;
import vendingmachine.io.writer.Writer;
import vendingmachine.view.constants.PrintFormat;

import java.util.List;

import static vendingmachine.view.constants.PrintFormat.*;
import static vendingmachine.view.constants.PrintMessage.*;

public class InputView {
    private final Writer writer;
    private final Reader reader;
    private final RetryHandler retryHandler;

    public InputView(Writer writer, Reader reader, RetryHandler retryHandler) {
        this.writer = writer;
        this.reader = reader;
        this.retryHandler = retryHandler;
    }

    public VendingMachineOwnMoney readMoneyInVendingMachine() {
        writer.writeln(INPUT_VENDINGMACHINE_OWN_AMOUNT_MSG.getMessage());
        return retryHandler.retryUntilSuccess(this::getMoneyInVendingMachine);
    }

    public VendingMachineOwnMoney getMoneyInVendingMachine() {
        int totalAmount = Converter.convertToInt(reader.readLine());
        return VendingMachineOwnMoney.from(totalAmount);
    }


    public ProductInfos readProductInfo() {
        writer.writeln(INPUT_NAME_PRICE_QUANTITY_MSG.getMessage());
        return retryHandler.retryUntilSuccess(this::getProductInfo);
    }
    public ProductInfos getProductInfo() {
        List<ProductInfo> productInfos = Converter.convertToTriple(reader.readLine());
        return new ProductInfos(productInfos);
    }

    public int readPaidMoney() {
        writer.writeln(INPUT_MONEY_AMOUNT_MSG.getMessage());
        return retryHandler.retryUntilSuccess(this::getPaidMoney);
    }
    public int getPaidMoney() {
        return Converter.convertToInt(reader.readLine());
    }

    public String readProductName(int paidMoney) {
        writer.writef(PAID_MONEY_FORMAT.getFormat(), paidMoney);
        writer.writeln(INPUT_NAME_OF_PRODUCT_MSG.getMessage());
        return reader.readLine();
    }
}
