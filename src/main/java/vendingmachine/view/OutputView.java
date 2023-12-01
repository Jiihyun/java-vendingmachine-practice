package vendingmachine.view;

import vendingmachine.domain.dto.output.PossessCoinResponse;
import vendingmachine.io.writer.Writer;
import vendingmachine.view.constants.PrintMessage;

import static vendingmachine.view.constants.PrintFormat.QUANTITY_FORMAT;
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
}
