package tddbc;

import java.util.Arrays;

public class MyCards {

    private final int[] cards;

    public MyCards(int one, int two, int three, int four, int five) {
        cards = new int[14];
        cards[one] += 1;
        cards[two] += 1;
        cards[three] += 1;
        cards[four] += 1;
        cards[five] += 1;

    }

    public PorkerHand whatHand() {
        if (isワンペア()) {
            return PorkerHand.ワンペア;
        }
        return PorkerHand.ブタ;
    }

    public boolean isワンペア() {
        return Arrays.stream(cards).anyMatch(value -> value == 2);
    }
}
