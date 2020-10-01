package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  private static final Suit DUMMY_SUIT = Suit.CLUBS;

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Hand hand = createHandWithRanksOf("A", "5");

    assertThat(hand.value())
        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceOtherCardsValueAt10HasValueOf11() throws Exception {
    Hand hand = createHandWithRanksOf("A", "10");

    assertThat(hand.value())
        .isEqualTo(11 + 10);
  }

  @Test
  public void handWithOneAceOtherCardsValueAt11HasValueOf1() throws Exception {
    Hand hand = createHandWithRanksOf("A", "9", "3");

    assertThat(hand.value())
        .isEqualTo(1 + 9 + 3);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Hand hand = createHandWithRanksOf("A", "8", "3");

    assertThat(hand.value())
        .isEqualTo(1 + 8 + 3);
  }

  private Hand createHandWithRanksOf(String... ranks) {
    Deck stubDeck = new StubDeck(ranks);
    Hand hand = new Hand();
    for (int i = 0; i < ranks.length; i++) {
      hand.drawCardFrom(stubDeck);
    }
    return hand;
  }

  private static class StubDeck extends Deck {
    private final Iterator<String> rankIterator;

    private StubDeck(String... ranks) {
      this.rankIterator = Arrays.stream(ranks).iterator();
    }

    @Override
    public Card draw() {
      return new Card(DUMMY_SUIT, rankIterator.next());
    }
  }

}
