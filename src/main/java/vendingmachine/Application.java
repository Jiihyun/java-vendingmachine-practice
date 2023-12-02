package vendingmachine;

import vendingmachine.controller.ProgramController;
import vendingmachine.io.reader.ConsoleReader;
import vendingmachine.io.writer.ConsoleWriter;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        ProgramController programController = getProgramController();
        programController.start();
    }

    private static ProgramController getProgramController() {
        ConsoleWriter writer = new ConsoleWriter();
        ConsoleReader reader = new ConsoleReader();
        InputView inputView = new InputView(writer, reader);
        OutputView outputView = new OutputView(writer);

        return new ProgramController(inputView, outputView);
    }
}
