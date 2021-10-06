package ui;

import javax.swing.*;
import model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ClubPointsWindow {
    League league;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel checkClub = new JLabel("Enter the name of the club");
    JTextField checkClubText = new JTextField();
    JButton backButton = new JButton("Check points ");


    ClubPointsWindow(League league) {
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        this.league = league;

        panel.setLayout(null);

        checkClub.setBounds(290, 200, 400, 80);
        panel.add(checkClub);

        checkClubText.setBounds(210, 250, 500, 25);
        panel.add(checkClubText);

        backButton.setBounds(330, 300, 270, 25);
        panel.add(backButton);

        backButton.addActionListener(e -> {
            new DisplayClubPoints(league, league.getClub(checkClubText.getText()));
            frame.dispose();
        });

        frame.setVisible(true);
    }


}
