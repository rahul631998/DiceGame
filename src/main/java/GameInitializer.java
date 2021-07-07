import Controller.GameController;
import Model.PlayerUtil;

public class GameInitializer {
    public static void main(String args[]) {
        Integer playerCount = Integer.parseInt(args[0]);
        Integer requiredPoints = Integer.parseInt(args[1]);

        PlayerUtil playerUtil = new PlayerUtil();
        playerUtil.populatePlayerList(playerCount);
        playerUtil.displayOrderOfPlaying();

        GameController gameController = new GameController(playerUtil.getPlayerList(), requiredPoints);
        gameController.playGame();
    }
}
