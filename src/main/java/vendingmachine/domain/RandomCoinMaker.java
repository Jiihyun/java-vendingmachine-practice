package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static vendingmachine.domain.Coin.*;

public class RandomCoinMaker {
    public int generate() {
        List<Integer> coinCategories = new ArrayList<>(Arrays.asList(
                COIN_500.getAmount(),
                COIN_100.getAmount(),
                COIN_50.getAmount(),
                COIN_10.getAmount()));
        return Randoms.pickNumberInList(coinCategories);
    }
}
