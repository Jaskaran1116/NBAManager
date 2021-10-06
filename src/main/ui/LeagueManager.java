//package ui;
//
//import model.*;
//import persistence.JsonReader;
//import persistence.JsonWriter;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.*;
//
//public class LeagueManager {
//    private static final String JSON_STORE = "./data/myLeague.json";
//    private League league;
//    private JsonWriter jsonWriter;
//    private JsonReader jsonReader;
//    public Scanner sc;
//    private Club myClub;
//    private Player myPlayer;
//    private LinkedList<Club> fantasyClub;
//
//
//
//    //EFFECTS: Runs the NBA management system
//    public LeagueManager() {
//        fantasyClub = new LinkedList<>();
//        jsonWriter = new JsonWriter(JSON_STORE);
//        jsonReader = new JsonReader(JSON_STORE);
//        sc = new Scanner(System.in);
//        league = new League("My Fantasy League");
//        myClub = new Club();
//        myPlayer = new Player("Lebron James", PositionType.SF, 23, 10);
//        runNbaManager();
//
//
//    }
//
//    //MODIFIES: this
//    //EFFECTS: processes the user input
//
//    private void runNbaManager() {
//        boolean keepGoing = true;
//        String command = null;
//
//        while (keepGoing) {
//            displayMenu();
//            command = sc.next();
//
//            if (command.equals("q")) {
//                keepGoing = false;
//            } else {
//                processCommand(command);
//            }
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: processes user command
//    private void processCommand(String command) {
//        if (command.equals("ac")) {
//            addClub();
//        } else if (command.equals("ap")) {
//            addPlayerMenu();
//        } else if (command.equals("sc")) {
//            showClub();
//        } else if (command.equals("pp")) {
//            showPlayerPoints();
//        } else if (command.equals("cp")) {
//            showClubPoints();
//        } else if (command.equals("sl")) {
//            saveLeague();
//        } else if (command.equals("ll")) {
//            loadLeague();
//        } else {
//            System.out.println("Selection not valid...");
//        }
//    }
//
//    private void displayMenu() {
//        System.out.println("\nWELCOME TO NBA MANAGER SYSTEM:");
//        System.out.println("\tac -> Create a new Club and add it to the fixtures ");
//        System.out.println("\tap -> Add a player to the club ");
////        System.out.println("\trp -> Remove player from the club ");
//        System.out.println("\tsc -> Displays the club ");
//        System.out.println("\tpp -> Check the player's points ");
//        System.out.println("\tcp -> Check the club points ");
//        System.out.println("\tsl -> Save the league to file ");
//        System.out.println("\tll -> Load the league to file ");
//        System.out.println("\tq -> quit");
//
//    }
//
//    public void addPlayerMenu() {
//        System.out.println("\nWELCOME TO NBA PLAYER MENU:");
//        System.out.println("\tc -> Add a player with position Center ");
//        System.out.println("\tpf -> Add a player with position Power Forward ");
//        System.out.println("\tsf -> Add a player with position Small Forward ");
//        System.out.println("\tpg -> Add a player with position Point Guard ");
//        System.out.println("\tsg -> Add a player with position Shooting Guard ");
//        System.out.println("\tq -> quit");
//        String playerDetails = sc.next();
//        if (playerDetails.equals("c")) {
//            addPlayerAtCenter();
//        } else if (playerDetails.equals("pf")) {
//            addPlayerAtPowerForward();
//        } else if (playerDetails.equals("sf")) {
//            addPlayerAtSmallForward();
//        } else if (playerDetails.equals("pg")) {
//            addPlayerAtPointGuard();
//        } else if (playerDetails.equals("sg")) {
//            addPlayerAtShootingGuard();
//        }
//    }
//
//    private void addPlayerAtCenter() {
//        if (selectClubAndAddPlayer()) {
//            System.out.println("Enter the name of the player ");
//            String playerName = sc.next();
//            System.out.println("Enter the number of baskets made by the player ");
//            int baskets = sc.nextInt();
//            System.out.println("Enter the number of assists made by the player ");
//            int assists = sc.nextInt();
//            Player myPlayer = new Player(playerName, PositionType.C, baskets, assists);
//            myClub.addPlayer(myPlayer);
//        } else {
//            System.out.println("CLUB doesn't exist");
//        }
//
//    }
//
//    private void addPlayerAtPowerForward() {
//        if (selectClubAndAddPlayer()) {
//            System.out.println("Enter the name of the player ");
//            String playerName = sc.next();
//            System.out.println("Enter the number of baskets made by the player ");
//            int baskets = sc.nextInt();
//            System.out.println("Enter the number of assists made by the player ");
//            int assists = sc.nextInt();
//            Player myPlayer = new Player(playerName, PositionType.C, baskets, assists);
//            myClub.addPlayer(myPlayer);
//        } else {
//            System.out.println("CLUB doesn't exist");
//        }
//    }
//
//    private void addPlayerAtSmallForward() {
//        if (selectClubAndAddPlayer()) {
//            System.out.println("Enter the name of the player ");
//            String playerName = sc.next();
//            System.out.println("Enter the number of baskets made by the player ");
//            int baskets = sc.nextInt();
//            System.out.println("Enter the number of assists made by the player ");
//            int assists = sc.nextInt();
//            Player myPlayer = new Player(playerName, PositionType.SF, baskets, assists);
//            myClub.addPlayer(myPlayer);
//        } else {
//            System.out.println("CLUB doesn't exist");
//        }
//    }
//
//    private void addPlayerAtPointGuard() {
//        if (selectClubAndAddPlayer()) {
//            System.out.println("Enter the name of the player ");
//            String playerName = sc.next();
//            System.out.println("Enter the number of baskets made by the player ");
//            int baskets = sc.nextInt();
//            System.out.println("Enter the number of assists made by the player ");
//            int assists = sc.nextInt();
//            Player myPlayer = new Player(playerName, PositionType.PG, baskets, assists);
//            myClub.addPlayer(myPlayer);
//        } else {
//            System.out.println("CLUB doesn't exist");
//        }
//
//    }
//
//    private void addPlayerAtShootingGuard() {
//        if (selectClubAndAddPlayer()) {
//            System.out.println("Enter the name of the player ");
//            String playerName = sc.next();
//            System.out.println("Enter the number of baskets made by the player ");
//            int baskets = sc.nextInt();
//            System.out.println("Enter the number of assists made by the player ");
//            int assists = sc.nextInt();
//            Player myPlayer = new Player(playerName, PositionType.SG, baskets, assists);
//            myClub.addPlayer(myPlayer);
//        } else {
//            System.out.println("CLUB doesn't exist");
//        }
//    }
//
//
//    private void addClub() {
//        Club club = new Club();
//        System.out.println("Enter the name of your club");
//        String line = sc.next();
//        club.setClubName(line);
//        league.addClub(club);
//    }
//
//
//
//
////    private void deletePlayer(Club club) {
////        System.out.println("Enter the name of the player");
////        Set<String> playerNames = club.getPlayerNames();
////        String playerName = sc.next();
////        if (playerNames.contains(playerName)) {
////            if (club.removePlayer(playerName)) {
////                System.out.println("player removed");
////            }
////        }
////    }
//
//
//    private void showClub() {
//
//        for (Club club : league.getClubs()) {
//            System.out.println(club.getClubName());
//        }
//    }
//
//
//
//
//    private void showPlayerPoints() {
//        String pointsPlayer;
//        System.out.println("Enter the name of the player whose points you want to check ");
//        pointsPlayer = sc.next();
//        System.out.println(pointsPlayer + " has " + myClub.getPlayer(pointsPlayer).calculateFantasyPoints()
//                + " Points!");
//
//    }
//
//    private void showClubPoints() {
//        System.out.println("Enter the name of the club");
//        LinkedList<String> clubNames = new LinkedList<>();
//        for (Club club : league.getClubs()) {
//            clubNames.add(club.getClubName());
//        }
//        String clubName = sc.next();
//        if (clubNames.contains(clubName)) {
//            for (Club nextClub : league.getClubs()) {
//                if (nextClub.getClubName().equals(clubName)) {
//                    System.out.println("Your club has " + nextClub.getAndSetTotalPoints() + " points!");
//                }
//            }
//        }
//    }
//
//    private boolean selectClubAndAddPlayer() {
//        String clubName;
//        System.out.println("Enter the club where you want to place the player ");
//        clubName = sc.next();
//        for (Club c : league.getClubs()) {
//            if (clubName.equals(c.getClubName())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    //EFFECTS: Saves the league to file
//    private void saveLeague() {
//        try {
//            jsonWriter.open();
//            jsonWriter.write(league);
//            jsonWriter.close();
//            System.out.println("Saved " + league.getName() + " to " + JSON_STORE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write to file: " + JSON_STORE);
//        }
//
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads league from file
//    private void loadLeague() {
//        try {
//            league = jsonReader.read();
//            System.out.println("Loaded " + league.getName() + " from " + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE);
//        }
//    }
//}
