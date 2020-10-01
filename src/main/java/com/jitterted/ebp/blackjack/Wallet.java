package com.jitterted.ebp.blackjack;

public class Wallet {

  private int balance = 0;

  public boolean isEmpty() {
    return balance == 0;
  }

  public void addMoney(int amount) {
    balance += amount;
  }

  public int balance() {
    return balance;
  }

  public void bet(int betAmount) {
    requireBalanceMoreThanBetAmount(betAmount);
    balance -= betAmount;
  }

  private void requireBalanceMoreThanBetAmount(int betAmount) {
    if (betAmount > balance) {
      throw new IllegalArgumentException();
    }
  }
}
