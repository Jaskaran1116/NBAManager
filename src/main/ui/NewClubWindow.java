package ui;


import model.Club;
import model.League;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Scanner;

public class NewClubWindow {
    League league;
    Club club;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel createClub = new JLabel("Enter the name of the club");
    JTextField createClubText = new JTextField();
    JButton backButton = new JButton("Save and go back to the menu");

    NewClubWindow(League league) {
        this.league = league;

        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        createClub.setBounds(380, 200, 200, 80);
        panel.add(createClub);

        createClubText.setBounds(210, 250, 500, 25);
        panel.add(createClubText);

        backButton.setBounds(330, 300, 270, 25);
        panel.add(backButton);

        backButton.addActionListener(e -> {
            String clubName = createClubText.getText();
            createClub(clubName);
            frame.dispose();
            new LaunchMenuPage(league);
        });

        frame.setVisible(true);

    }


    //Creates and adds a club to the fantasy league
    private void createClub(String clubName) {
        club = new Club(clubName, new LinkedList<>(), 0);
        league.addClub(club);
    }
}

