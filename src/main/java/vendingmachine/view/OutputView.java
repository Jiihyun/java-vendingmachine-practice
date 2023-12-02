package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.dto.output.PossessCoinResponse;
import vendingmachine.io.writer.Writer;
import vendingmachine.view.constants.PrintFormat;

import java.util.Map;

import static vendingmachine.view.constants.PrintFormat.*;
import static vendingmachine.view.constants.PrintMessage.*;

public class OutputView {
    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void printQuantities(PossessCoinResponse possessCoinResponse) {
        writer.writeln(OUTPUT_COIN_QUANTITY_MSG.getMessage());
        writer.writef(QUANTITY_FORMAT.getFormat(),
                possessCoinResponse.quantityOf500(),
                possessCoinResponse.quantityOf100(),
                possessCoinResponse.quantityOf50(),
                possessCoinResponse.quantityOf10());
    }

    public void printChange(int paidMoney, Map<Coin, Integer> change) {
        writer.writef(PAID_MONEY_FORMAT.getFormat(), paidMoney);
        writer.writeln(OUTPUT_CHANGE_MSG.getMessage());
        for (Map.Entry<Coin, Integer> changeEntry : change.entrySet()) {
        writer.writef(CHANGE_FORMAT.getFormat(), changeEntry.getKey().getAmount(), changeEntry.getValue());
        }
    }
}
