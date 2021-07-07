package Model;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerUtil {
    private ArrayList<Player> playerList;

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public PlayerUtil() {
        playerList = new ArrayList<>();
    }

    public void populatePlayerList(Integer playerCount) {
        for (int i = 1; i <= playerCount; i++) {
            Player playerObj = new Player(0, "Player-" + i, 0);
            playerList.add(playerObj);
        }
        Collections.shuffle(playerList);
    }

    public void displayOrderOfPlaying() {
        System.out.println("Order of Game Play\n");
        for (Player player : playerList) {
            System.out.print(player.getPlayerName() + "->");
        }
        System.out.println("\n\n");
    }
}
