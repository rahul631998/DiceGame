package Model;

public class Player {
    private Integer points;
    private String playerName;
    private Integer consecutiveOne;

    Player(Integer points, String playerName, Integer consecutiveOne) {
        this.points = points;
        this.playerName = playerName;
        this.consecutiveOne = consecutiveOne;
    }


    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getConsecutiveOne() {
        return consecutiveOne;
    }

    public void setConsecutiveOne(Integer consecutiveOne) {
        this.consecutiveOne = consecutiveOne;
    }

}
