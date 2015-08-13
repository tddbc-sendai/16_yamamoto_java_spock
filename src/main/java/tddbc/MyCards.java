package tddbc;

import java.util.HashSet;
import java.util.Set;

public class MyCards {

//    private final int one;
//    private final int two;
//    private final int three;
//    private final int four;
//    private final int five;

    private final Set<Integer> cards;

    public MyCards(int one, int two, int three, int four, int five) {
        cards = new HashSet<>();
        cards.add(one);
        cards.add(two);
        cards.add(three);
        cards.add(four);
        cards.add(five);
    }

    public PorkerHand whatHand() {
        if (cards.size() >= 5) {
            return PorkerHand.ブタ;
        }
        if (cards.size() == 4) {

            return PorkerHand.ワンペア;
        }
        return PorkerHand.ツーペア;
    }
}
