package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayerBettingTest {

  // playerWins
  // playerLoses
  // playerPushes
  // playerHasBlackjack = Bet + Bet + 50% Bet

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

  @Test
  public void playerWith25Bets15AndLosesHasBalance10() throws Exception {
    Game game = new Game();
    game.playerDeposits(25);

    game.playerBets(15);
    game.playerLoses();

    assertThat(game.playerBalance())
        .isEqualTo(25 - 15);
  }

  @Test
  public void playerWith35Bets17AndPushesHasBalance35() throws Exception {
    Game game = new Game();
    game.playerDeposits(35);

    game.playerBets(17);
    game.playerPushes();

    assertThat(game.playerBalance())
        .isEqualTo(35 - 17 + 17);
  }

  @Test
  public void playerWith100Bets50AndBlackjackHasBalance175() throws Exception {
    Game game = new Game();
    game.playerDeposits(100);

    game.playerBets(50);
    game.playerBlackjack();

    assertThat(game.playerBalance())
        .isEqualTo(100 - 50 + (int) (50 * 2.5));
  }

}