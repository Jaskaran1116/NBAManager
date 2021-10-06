package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class Club implements Writable {
    private String clubName;
    private LinkedList<Player> squad;
    private int clubPoints;


    public Club() {
        squad = new LinkedList<>();
        clubPoints = 0;

    }

    public Club(String name, LinkedList<Player> squad, int clubPoints) {
        this.clubName = name;
        this.squad = squad;
        this.clubPoints = clubPoints;

    }

    //EFFECTS: Returns the name of the club
    public String getClubName() {
        return clubName;
    }

    public void setClubName(String name) {
        this.clubName = name;
    }


    //EFFECTS: Gets all the players in the squad.
    public LinkedList<Player> getPlayers() {
        return squad;
    }

    //MODIFIES: this
    //EFFECTS: Returns the players in the club
    public Player getPlayer(String playerName) {
        for (Player player : squad) {
            if (player.getPlayerName().equals(playerName)) {
                return player;
            }

        }
        return null;
    }

    //EFFECTS: returns the size of the squad
    public int squadSize() {
        return squad.size();
    }

    //MODIFIES: this, player
    //EFFECTS: if squadSize() > 6, throw ClubFullException,
    // otherwise, add a player to the club's squad.
    public void addPlayer(Player player) throws ClubFullException {
        if (squad.size() < 6) {
            squad.add(player);
        } else {
            throw new ClubFullException();
        }

    }

    //EFFECTS: returns the name of all players in the squad
    public Set<String> getPlayerNames() {
        Set<String> playerNames = new HashSet<>();
        for (Player player : squad) {
            playerNames.add(player.getPlayerName());
        }
        return playerNames;
    }

    //EFFECTS: returns the total points of the club
    public int getAndSetTotalPoints() {
        int cp = 0;
        for (Player player : squad) {
            if (player.getType() == PositionType.C) {
                cp = cp + player.calculateFantasyPoints();
            } else if (player.getType() == PositionType.PF) {
                cp = cp + player.calculateFantasyPoints();
            } else if (player.getType() == PositionType.SF) {
                cp = cp + player.calculateFantasyPoints();
            } else if (player.getType() == PositionType.PG) {
                cp = cp + player.calculateFantasyPoints();
            } else {
                cp = cp + player.calculateFantasyPoints();
            }
        }
        clubPoints = cp;
        return clubPoints;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray playersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Player t : getPlayers()) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("clubName", clubName);
        json.put("squad", playersToJson());
        json.put("clubPoints", clubPoints);
        return json;
    }
}
