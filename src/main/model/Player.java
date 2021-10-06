package model;


import org.json.JSONObject;
import persistence.Writable;

public class Player implements Writable {
    private String playerName;
    private PositionType playerPosition;
    private int playerBasket;
    private int playerAssist;
    private int playerPoints;


    public Player(String nm, PositionType pos, int basket, int assist) {
        this.playerName = nm;
        this.playerPosition = pos;
        this.playerBasket = basket;
        this.playerAssist = assist;
        playerPoints = 0;
    }

    public Player(String playerName, PositionType playerPosition, int playerBasket, int playerAssist,
                  int playerPoints) {
        this.playerName = playerName;
        this.playerPosition = playerPosition;
        this.playerBasket = playerBasket;
        this.playerAssist = playerAssist;
    }

    //EFFECTS: Returns the name of the player
    public String getPlayerName() {
        return playerName;
    }

    //EFFECTS: returns the position of the player
    public PositionType getType() {
        return playerPosition;
    }

    //EFFECTS: returns the number of baskets the player has made
    public int getPlayerBasket() {
        return playerBasket;
    }

    //EFFECTS: returns the number of assists the player has made
    public int getPlayerAssist() {
        return playerAssist;
    }

    //MODIFIES: this
    //EFFECTS: Returns the number of points the player has received
    public int calculateFantasyPoints() {
        PositionType pt = this.getType();
        if (pt == PositionType.C) {
            playerPoints = (getPlayerBasket() * 5);
        } else if (pt == PositionType.PF) {
            playerPoints = (getPlayerBasket() * 5) + (getPlayerAssist() * 3);
        } else if (pt == PositionType.SF) {
            playerPoints = (getPlayerBasket() * 7) + (getPlayerAssist() * 3);
        } else if (pt == PositionType.PG) {
            playerPoints = (getPlayerBasket() * 8) + (getPlayerAssist() * 3);
        } else {
            playerPoints = (getPlayerBasket() * 10) + (getPlayerAssist() * 3);
        }

        return playerPoints;

    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("playerName", playerName);
        json.put("playerPosition", playerPosition);
        json.put("playerBasket", playerBasket);
        json.put("playerAssist", playerAssist);
        json.put("playerPoints", playerPoints);
        return json;
    }

}

