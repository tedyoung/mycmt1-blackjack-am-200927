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
  public void add8Andadd9ToWalletHasBalanceOf17() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(8);
    wallet.addMoney(9);

    assertThat(wallet.balance())
        .isEqualTo(8 + 9);
  }

}
