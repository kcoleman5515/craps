package edu.cnm.deepdive;

import java.util.Random;

public class Main {

  public static void main(String[] args) {
    int rounds = (args.length > 0) ? Integer.parseInt(args[0]) : 1;
    play(rounds);
  }

  private static void play(int rounds) {
    Random rng = new Random();
    Game game = new Game(rng);
    Round round = game.play(rounds);
    if (rounds == 1) {
      System.out.println("Rolls:");
      for (Roll roll :
          round.getRolls()) {
        System.out.printf("\t%s = %2d%n", roll, roll.getValue());
      }
      System.out.printf("The round outcome was a %s%n", round.getState());
    } else {
      System.out.printf("Rounds played: %d%n", game.getPlays());
      System.out.printf("Wins: %d%n", game.getWins());
      System.out.printf("Winning percentage: %.2f%%%n", game.getPercentage() * 100);
    }
  }

}
