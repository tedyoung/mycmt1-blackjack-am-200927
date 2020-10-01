package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

  @Test
  public void newWalletIsEmpty() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void addMoneyToWalletIsNotEmpty() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(10);

    assertThat(wallet.isEmpty())
        .isFalse();
  }

  @Test
  public void newWalletHasZeroBalance() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.balance())
        .isZero();
  }

  @Test
  public void add7ToWalletHasBalanceOf7() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(7);

    assertThat(wallet.balance())
        .isEqualTo(7);
  }

  @Test
  public void add8AndAdd9ToWalletHasBalanceOf17() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(8);
    wallet.addMoney(9);

    assertThat(wallet.balance())
        .isEqualTo(8 + 9);
  }

  @Test
  public void walletWith12Bet5HasBalanceOf7() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(12);

    wallet.bet(5);

    assertThat(wallet.balance())
        .isEqualTo(12 - 5);
  }

  @Test
  public void walletWith45Bet15AndBet22HasBalanceOf8() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(45);

    wallet.bet(15);
    wallet.bet(22);

    assertThat(wallet.balance())
        .isEqualTo(45 - 15 - 22);
  }

  @Test
  public void walletWith16Bet16IsEmpty() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(16);

    wallet.bet(16);

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void walletWith50Bet51ThrowsException() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(50);

    assertThatThrownBy(() -> {
      wallet.bet(51);
    })
        .isInstanceOf(IllegalArgumentException.class);
  }

}
