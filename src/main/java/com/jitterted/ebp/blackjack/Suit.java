package com.jitterted.ebp.blackjack;

public enum Suit {
  HEARTS("♥", true),
  DIAMONDS("♦", true),
  CLUBS("♣", false),
  SPADES("♠", false);

  private final String symbol;
  private final boolean isRed;

  Suit(String symbol, boolean isRed) {
    this.symbol = symbol;
    this.isRed = isRed;
  }

  public String symbol() {
    return symbol;
  }

  public boolean isRed() {
    return isRed;
  }
}
