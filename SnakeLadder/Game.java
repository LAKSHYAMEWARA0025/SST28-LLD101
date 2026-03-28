package SnakeLadder;

import java.util.List;

public class Game {

    private List<Player> players;
    private Board board;
    private Dice dice;
    private IStrategy strategy;

    public Game(List<Player> players, Board board, IStrategy strategy) {
        this.players = players;
        this.board = board;
        this.strategy = strategy;
        this.dice = new Dice();
    }

    public void start() {

        boolean gameWon = false;

        while (!gameWon) {

            for (Player player : players) {

                int roll = dice.roll();
                System.out.println(player.getName() + " rolled " + roll);

                if (!strategy.canPlay(player, roll)) {
                    System.out.println("Turn skipped!");
                    continue;
                }

                int newPosition = player.getPosition() + roll;

                if (newPosition > board.getWinningPosition()) {
                    continue;
                }

                newPosition = board.applyMove(newPosition);
                player.setPosition(newPosition);

                System.out.println(player.getName() + " moved to " + newPosition);

                if (newPosition == board.getWinningPosition()) {
                    System.out.println(player.getName() + " wins!");
                    gameWon = true;
                    break;
                }
            }
        }
    }
}