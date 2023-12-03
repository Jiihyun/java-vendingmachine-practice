package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.domain.ProductInfos;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.VendingMachineCoins;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.Map;

public class ProgramController {
    private final InputView inputView;
    private final OutputView outputView;

    public ProgramController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        VendingMachineCoins moneyInVendingMachine = inputView.readMoneyInVendingMachine();
        outputView.printQuantities(moneyInVendingMachine.getQuantities());

        ProductInfos productInfos = inputView.readProductInfo();
        int paidMoney = inputView.readPaidMoney();

        VendingMachine vendingMachine = VendingMachine.of(productInfos, paidMoney);
        while (productInfos.getProductOfLowestPrice() <= vendingMachine.getRemainMoney()) {
            vendingMachine.buyProduct(inputView.readProductName(vendingMachine.getRemainMoney()));
        }

        Map<Coin, Integer> change = vendingMachine.returnChange(moneyInVendingMachine, vendingMachine.getRemainMoney());
        outputView.printChange(vendingMachine.getRemainMoney(), change);
    }
}
