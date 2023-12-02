package vendingmachine;

import vendingmachine.controller.ProgramController;
import vendingmachine.io.reader.ConsoleReader;
import vendingmachine.io.writer.ConsoleWriter;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;
import vendingmachine.view.RetryHandler;

public class Application {
    public static void main(String[] args) {
        ProgramController programController = getProgramController();
        programController.start();
    }

    private static ProgramController getProgramController() {
        ConsoleWriter writer = new ConsoleWriter();
        ConsoleReader reader = new ConsoleReader();
        RetryHandler retryHandler = new RetryHandler(writer);
        InputView inputView = new InputView(writer, reader, retryHandler);
        OutputView outputView = new OutputView(writer);

        return new ProgramController(inputView, outputView);
    }
}
