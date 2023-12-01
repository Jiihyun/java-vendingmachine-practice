package vendingmachine.controller;

import vendingmachine.domain.VendingMachineOwnMoney;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ProgramController {
    private final InputView inputView;
    private final OutputView outputView;

    public ProgramController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        VendingMachineOwnMoney moneyInVendingMachine = inputView.getMoneyInVendingMachine();
        outputView.printQuantities(moneyInVendingMachine.getQuantities());
    }
}
