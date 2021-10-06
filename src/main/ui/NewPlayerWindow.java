package ui;


import model.*;
import persistence.*;
import sun.misc.JavaLangAccess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


public class NewPlayerWindow {
    League league;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel placePlayerInClub = new JLabel("Enter the club where you want to place the player");
    JLabel playerPosition = new JLabel("Enter Player Position");
    JLabel playerName = new JLabel("Enter Player Name");
    JLabel playerBaskets = new JLabel("Enter Player Baskets");
    JLabel playerAssists = new JLabel("Enter Player Assists");
    JTextField placePlayer = new JTextField();
    JTextField playerPositionText = new JTextField();
    JTextField playerNameText = new JTextField();
    JTextField playerBasketText = new JTextField();
    JTextField playerAssistText = new JTextField();
    JButton backButton = new JButton("Save and go back to menu");


    NewPlayerWindow(League league) {
        this.league = league;

        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        labelAndTextFieldsHelper();


        backButton.setBounds(400, 330, 200, 25);
        panel.add(backButton);
        backButton.addActionListener(e -> {
            try {
                positionHelper();
            } catch (ClubFullException clubFullException) {
                clubFullException.printStackTrace();
            }

            frame.dispose();
            new LaunchMenuPage(league);
        });

        frame.setVisible(true);
    }

    private void positionHelper() throws ClubFullException {
        String position = playerPositionText.getText();
        switch (position) {
            case("c"): addPlayerAtCenter();
            break;
            case("pg"): addPlayerAtPointGuard();
            break;
            case("pf"): addPlayerAtPowerForward();
            break;
            case("sg"): addPlayerAtShootingGuard();
            break;
            case("sf"): addPlayerAtSmallForward();
            break;
        }
    }


    private void labelAndTextFieldsHelper() {
        placePlayerInClub.setBounds(100, 80, 400, 25);
        panel.add(placePlayerInClub);

        placePlayer.setBounds(450, 80, 300, 25);
        panel.add(placePlayer);

        playerPosition.setBounds(100, 130, 120, 25);
        panel.add(playerPosition);

        playerPositionText.setBounds(450, 130, 300, 25);
        panel.add(playerPositionText);


        playerName.setBounds(100, 180, 120, 25);
        panel.add(playerName);

        playerNameText.setBounds(450, 180, 300, 25);
        panel.add(playerNameText);


        playerBaskets.setBounds(100, 230, 120, 25);
        panel.add(playerBaskets);

        playerBasketText.setBounds(450, 230, 300, 25);
        panel.add(playerBasketText);


        playerAssists.setBounds(100, 280, 120, 25);
        panel.add(playerAssists);

        playerAssistText.setBounds(450, 280, 300, 25);
        panel.add(playerAssistText);
    }

    //REQUIRES: PositionType == C
    //EFFECTS: Adds a player to a club with a center position type
    private void addPlayerAtCenter() throws ClubFullException {
        if (selectClubAndAddPlayer()) {
            Player myPlayer = new Player(playerNameText.getText(), PositionType.C,
                    Integer.parseInt(playerBasketText.getText()),
                    Integer.parseInt(playerAssistText.getText()));
            league.getClub(placePlayer.getText()).addPlayer(myPlayer);
        }

    }

    //REQUIRES: PositionType == PF
    //EFFECTS: Adds a player to a club with a Power Forward position type
    private void addPlayerAtPowerForward() throws ClubFullException {
        if (selectClubAndAddPlayer()) {
            Player myPlayer = new Player(playerNameText.getText(), PositionType.PF,
                    Integer.parseInt(playerBasketText.getText()),
                    Integer.parseInt(playerAssistText.getText()));
            league.getClub(placePlayer.getText()).addPlayer(myPlayer);

        }

    }

    //REQUIRES: PositionType == SF
    //EFFECTS: Adds a player to a club with a Small Forward position type
    private void addPlayerAtSmallForward() throws ClubFullException {
        if (selectClubAndAddPlayer()) {
            Player myPlayer = new Player(playerNameText.getText(), PositionType.SF,
                    Integer.parseInt(playerBasketText.getText()),
                    Integer.parseInt(playerAssistText.getText()));
            league.getClub(placePlayer.getText()).addPlayer(myPlayer);

        }

    }

    //REQUIRES: PositionType == PG
    //EFFECTS: Adds a player to a club with a Point Guard position type
    private void addPlayerAtPointGuard() throws ClubFullException {
        if (selectClubAndAddPlayer()) {
            Player myPlayer = new Player(playerNameText.getText(), PositionType.PG,
                    Integer.parseInt(playerBasketText.getText()),
                    Integer.parseInt(playerAssistText.getText()));
            league.getClub(placePlayer.getText()).addPlayer(myPlayer);

        }

    }

    //REQUIRES: PositionType == SG
    //EFFECTS: Adds a player to a club with a Shooting Guard position type
    private void addPlayerAtShootingGuard() throws ClubFullException {
        if (selectClubAndAddPlayer()) {
            Player myPlayer = new Player(playerNameText.getText(), PositionType.SG,
                    Integer.parseInt(playerBasketText.getText()),
                    Integer.parseInt(playerAssistText.getText()));
            league.getClub(placePlayer.getText()).addPlayer(myPlayer);

        }

    }


    //EFFECTS: Returns true if the clubName matches the name of the club in the fantasy league.
    private Boolean selectClubAndAddPlayer() {
        String clubName = placePlayer.getText();
        for (Club club : league.getClubs()) {
            if (clubName.equals(club.getClubName())) {
                return true;
            }
        }
        return false;
    }


}
