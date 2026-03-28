package SnakeLadder;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("A");
        Player p2 = new Player("B");

        List<Player> players = Arrays.asList(p1, p2);

        List<BoardObject> objects = new ArrayList<>();
        objects.add(new Snake(14, 7));
        objects.add(new Ladder(3, 22));

        Board board = new Board(10, objects);

        IStrategy strategy = new MediumStrategy();

        Game game = new Game(players, board, strategy);
        game.start();
    }
}