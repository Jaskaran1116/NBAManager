package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Stream;
import java.util.LinkedList;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public League read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseLeague(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private League parseLeague(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        League league = new League(name);
        addClubs(league, jsonObject);
        return league;
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private LinkedList<Player> parseSquad(JSONArray jsonArray) {
        LinkedList<Player> players = new LinkedList<>();
        for (Object json : jsonArray) {
            players.add(parsePlayer((JSONObject) json));
        }
        return players;
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Player parsePlayer(JSONObject jsonObject) {
        String playerName = jsonObject.getString("playerName");
        PositionType playerPosition = PositionType.valueOf(jsonObject.getString("playerPosition"));
        int playerBasket = jsonObject.getInt("playerBasket");
        int playerAssist = jsonObject.getInt("playerAssist");
        int playerPoints = jsonObject.getInt("playerPoints");

        return new Player(playerName, playerPosition, playerBasket, playerAssist,playerPoints);
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addClubs(League league, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("fantasyClub");
        for (Object json : jsonArray) {
            JSONObject nextClub = (JSONObject) json;
            addClub(league, nextClub);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addClub(League league, JSONObject jsonObject) {
        String name = jsonObject.getString("clubName");
        LinkedList<Player> squad = parseSquad(jsonObject.getJSONArray("squad"));
        int clubPoints = jsonObject.getInt("clubPoints");

        Club club = new Club(name, squad, clubPoints);
        league.addClub(club);
    }
}



