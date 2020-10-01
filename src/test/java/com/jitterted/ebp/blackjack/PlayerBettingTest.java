package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayerBettingTest {

  // playerWins
  // playerLoses
  // playerPushes
  // playerHasBlackjack

  @Test
  public void playerDeposits20HasBalanceOf20() throws Exception {
    Game game = new Game();
    game.playerDeposits(20);

    assertThat(game.playerBalance())
        .isEqualTo(20);
  }

  @Test
  public void balanceOf20Bets5BalanceIs15() throws Exception {
    Game game = new Game();
    game.playerDeposits(20);

    game.playerBets(5);

    assertThat(game.playerBalance())
        .isEqualTo(20 - 5);

  }

  // Player Wins: player gets 2x bet
  @Test
  public void playerWith20Bets10WinsHasBalance30() throws Exception {
    Game game = new Game();
    game.playerDeposits(20);

    game.playerBets(10);
    game.playerWins();

    int winAmount = 2 * 10;
    assertThat(game.playerBalance())
        .isEqualTo(20 - 10 + winAmount);
  }
}