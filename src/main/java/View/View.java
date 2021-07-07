package View;

import Model.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;

public class View {
    public static final String statsHeader = "=============stats==============";
    public static final String statsFooter = "=============+++++==============\n";
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayStats(Queue<Player> playerQueue, ArrayList<Player> playersFinishedTheGame) {

        ArrayList<Player> sortedPlayerList = new ArrayList<>(playerQueue);
        sortedPlayerList.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getPoints() <= o2.getPoints() ? 0 : -1;
            }
        });

        displayMessage(statsHeader);

        displayMessage("Rank\t\tPlayer Name\t\tPoints\t\tFinished");

        Integer rank = 1;

        for (Player player : playersFinishedTheGame) {
            displayMessage(rank + "\t\t\t" + player.getPlayerName() + "\t\t" + player.getPoints() + "\t\t\tYes");
            rank++;
        }
        for (Player player : sortedPlayerList) {
            displayMessage(rank + "\t\t\t" + player.getPlayerName() + "\t\t" + player.getPoints() + "\t\t\tNo");
            rank++;
        }

        displayMessage(statsFooter);
    }
}
