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
        if (isストレート()) {
            return PorkerHand.ストレート;
        }
        if (isスリーカード()) {
            return PorkerHand.スリーカード;
        }
        if (isツーペア()) {
            return PorkerHand.ツーペア;
        }
        if (isワンペア()) {
            return PorkerHand.ワンペア;
        }
        return PorkerHand.ブタ;
    }

    public boolean isワンペア() {
        return Arrays.stream(cards).anyMatch(card -> card == 2);
    }

    public boolean isツーペア() {
        return Arrays.stream(cards).filter(card -> card == 2).count() == 2;
    }

    public boolean isスリーカード() {
        return Arrays.stream(cards).anyMatch(card -> card == 3);
    }

    public boolean isストレート() {
        int[] straightCards = new int[14];
        int minIndex = getMinIndex(this.cards);
        straightCards[minIndex++] = 1;
        straightCards[minIndex++] = 1;
        straightCards[minIndex++] = 1;
        straightCards[minIndex++] = 1;
        straightCards[minIndex] = 1;

        int[] highStraightCards = new int[14];
        highStraightCards[10] = 1;
        highStraightCards[11] = 1;
        highStraightCards[12] = 1;
        highStraightCards[13] = 1;
        highStraightCards[1] = 1;

        return Arrays.equals(straightCards, this.cards) || Arrays.equals(highStraightCards, this.cards);
    }

    private int getMinIndex(int[] straightCards) {
        int i = 0;
        for (; i < straightCards.length; i++) {
            if (straightCards[i] == 1)
                break;
        }
        return i;
    }
}
