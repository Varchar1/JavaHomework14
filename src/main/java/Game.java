import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int strength1;
        int strength2;
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not found"
            );
        } else {
            strength1 = findByName(playerName1);
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName2 + " not found"
            );
        } else {
            strength2 = findByName(playerName2);
        }

        if (strength1 > strength2) {
            return 1;
        } else if (strength1 < strength2) {
            return 2;
        } else  {
            return 0;
        }
    }

    public Integer findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                int strength = player.getStrength();
                return strength;
            }
        }
        return null;
    }
}
