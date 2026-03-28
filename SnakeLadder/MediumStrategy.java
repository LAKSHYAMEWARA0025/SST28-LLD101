package SnakeLadder;

// import model.Player;
import java.util.HashMap;
import java.util.Map;

public class MediumStrategy implements IStrategy {

    private Map<Player, Integer> sixCount = new HashMap<>();

    public boolean canPlay(Player player, int diceValue) {

        if (diceValue == 6) {
            sixCount.put(player, sixCount.getOrDefault(player, 0) + 1);
        } else {
            sixCount.put(player, 0);
        }

        if (sixCount.get(player) == 3) {
            sixCount.put(player, 0);
            return false;
        }

        return true;
    }
}