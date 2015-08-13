package tddbc

import spock.lang.Specification
import spock.lang.Unroll

class SampleSpec extends Specification {

    @Unroll
    def "カードが #one,#two,#three,#four,#five であるとき、#result になること"() {

        given:
        def sut = new MyCards(one,two,three,four,five)

        when:
        def actual = sut.whatHand()

        then:
        actual == result

        where:
        one | two | three | four | five || result
        1   | 5   | 7     | 8    | 9    || PorkerHand.ブタ
        1   | 1   | 3     | 4    | 5    || PorkerHand.ワンペア
        1   | 1   | 2     | 2    | 5    || PorkerHand.ツーペア
        1   | 1   | 1     | 2    | 5    || PorkerHand.スリーカード
        2   | 3   | 4     | 5    | 6    || PorkerHand.ストレート
    }
}
