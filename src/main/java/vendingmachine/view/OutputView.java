package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.dto.output.CoinQuantitiesResponse;
import vendingmachine.io.writer.Writer;

import java.util.Map;

import static vendingmachine.view.constants.PrintFormat.*;
import static vendingmachine.view.constants.PrintMessage.*;

public class OutputView {
    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void printQuantities(CoinQuantitiesResponse coinQuantitiesResponse) {
        writer.writeln(OUTPUT_COIN_QUANTITY_MSG.getMessage());
        writer.writef(QUANTITY_FORMAT.getFormat(),
                coinQuantitiesResponse.quantityOf500(),
                coinQuantitiesResponse.quantityOf100(),
                coinQuantitiesResponse.quantityOf50(),
                coinQuantitiesResponse.quantityOf10());
    }

    public void printChange(int paidMoney, Map<Coin, Integer> change) {
        writer.writef(PAID_MONEY_FORMAT.getFormat(), paidMoney);
        writer.writeln(OUTPUT_CHANGE_MSG.getMessage());
        for (Map.Entry<Coin, Integer> changeEntry : change.entrySet()) {
        writer.writef(CHANGE_FORMAT.getFormat(), changeEntry.getKey().getAmount(), changeEntry.getValue());
        }
    }
}
