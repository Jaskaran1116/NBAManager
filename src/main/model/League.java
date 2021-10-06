package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import javax.swing.*;
import java.util.LinkedList;

import java.util.HashSet;

public class League implements Writable {
    private LinkedList<Club> clubs;
    private String name;

    public League(String name) {
        this.name = name;
        clubs = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    // EFFECTS: returns an unmodifiable list of clubs in this league
    public LinkedList<Club> getClubs() {
        return clubs;
    }

    public Club getClub(String clubName) {
        for (Club club : clubs) {
            if (club.getClubName().equals(clubName)) {
                return club;
            }
        }
        return null;
    }

    public void addClub(Club club) {
        if (clubs.contains(club)) {
            clubs.remove(club);
        }
        clubs.add(club);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("fantasyClub", fantasyClubToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray fantasyClubToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Club t : clubs) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

    public Player getPlayer(String pointsPlayer) {
        for (Club club : getClubs()) {
            if (club.getPlayer(pointsPlayer) != null) {
                return club.getPlayer(pointsPlayer);
            }
        }
        return null;
    }
}