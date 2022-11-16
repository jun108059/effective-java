package study.yjpark.chapter07.item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 데카르트 곱을 위한 카드 덱
 */
public class Card {
    public enum Suit {
        SPADE, HEART, DIAMOND, CLOVER
    }

    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private final Suit suit;
    private final Rank rank;

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;

    }

    private static final List<Card> NEW_DECK = newDeck();

    /**
     * [45-5] for loop 방식으로 구현한 데카르트 곱 계산
     *
     * @return Card 리스트 (데카르트 곱 결과)
     */
    private static List<Card> newDeck() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                result.add(new Card(suit, rank));
        return result;
    }

    /**
     * [45-6] Stream 활용한 데카르트 곱 계산
     *
     * @return Card 리스트 (데카르트 곱 결과)
     */
    private static List<Card> newDeckStream() {
        return Stream.of(Suit.values())
                .flatMap(suit ->
                        Stream.of(Rank.values())
                                .map(rank -> new Card(suit, rank)))
                .collect(toList());
    }

    public static void main(String[] args) {
        System.out.println(NEW_DECK);
    }
}
