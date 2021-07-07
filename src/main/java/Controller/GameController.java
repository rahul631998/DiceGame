package Controller;
import Model.Player;
import View.View;

import java.util.*;

public class GameController {


    Scanner sc = new Scanner(System.in);
    private Queue<Player> playerQueue;
    private ArrayList<Player> playersFinishedTheGame;
    private final Integer requiredPoints;
    private Integer currentRank;


    public GameController(ArrayList<Player> playerList, Integer requiredPoints) {
        playerQueue = new LinkedList<>(playerList);
        playersFinishedTheGame = new ArrayList<>();
        this.requiredPoints = requiredPoints;
        this.currentRank = 1;
    }


    public void playGame()
    {
        View view = new View();

        //loop while all player finish the game
        while(!playerQueue.isEmpty()) {

            Player player = playerQueue.peek();

            if (player.getConsecutiveOne() == 2) {
                view.displayMessage(player.getPlayerName() + " Your turn is skipped\n");
                player.setConsecutiveOne(0);
                playerQueue.add(playerQueue.poll());
                continue;
            }

            view.displayMessage(player.getPlayerName() + " its your turn (press ‘r’ to roll the dice)");
            while(!sc.next().equals("r")) {
                view.displayMessage(player.getPlayerName() + " its your turn (press ‘r’ to roll the dice)");
            };

            Integer numberOnDice = throwDice();
            view.displayMessage("You got " + numberOnDice + " points\n");


            if (numberOnDice == 1 && player.getConsecutiveOne() == 1) {
                skipChanceInNextRound(player);
            }

            player.setPoints(player.getPoints() + numberOnDice);

            if (player.getPoints() >= requiredPoints) {
                playerCompletedTheGame(player);
            }
            else {
                if(numberOnDice == 1 && player.getConsecutiveOne() == 0) {
                    player.setConsecutiveOne(1);
                }
                else if (numberOnDice == 6) {
                    rewardForSix();
                    continue;
                }
                playerQueue.add(playerQueue.poll());
                view.displayStats(playerQueue, playersFinishedTheGame);
            }
        }
        view.displayMessage("\n\n\n==========Final Results=========");
        view.displayStats(playerQueue, playersFinishedTheGame);
    }


    public Integer throwDice() {
        Random rn = new Random();
        return (rn.nextInt(6) + 1);
    }


    public void skipChanceInNextRound(Player player) {
        View view = new View();

        view.displayMessage("Opps!!! Two consecutive 1s. Your next turn will be skipped\n");
        player.setConsecutiveOne(2);
    }


    public void playerCompletedTheGame(Player player) {
        View view = new View();

        view.displayMessage(player.getPlayerName() + " You have finished the Game with Rank -> " + currentRank + "\n");
        playerQueue.poll();
        playersFinishedTheGame.add(player);
        currentRank++;
        view.displayStats(playerQueue, playersFinishedTheGame);
    }

    public void rewardForSix() {
        View view = new View();

        view.displayMessage("Congratulations!!! you have got another chance");
        view.displayStats(playerQueue, playersFinishedTheGame);
    }
}
