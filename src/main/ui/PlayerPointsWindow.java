package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.*;

import java.util.LinkedList;

public class PlayerPointsWindow extends JFrame {
    League league;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel checkPlayer = new JLabel("Enter the name of the player whose points you want to check");
    JTextField checkPlayerText = new JTextField();
    JButton checkPointsButton = new JButton("Check points");


    PlayerPointsWindow(League league) {
        this.league = league;
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        checkPlayer.setBounds(290, 200, 400, 80);
        panel.add(checkPlayer);

        checkPlayerText.setBounds(210, 250, 500, 25);
        panel.add(checkPlayerText);

        checkPointsButton.setBounds(330, 300, 270, 25);
        panel.add(checkPointsButton);

        checkPointsButton.addActionListener(e -> {
            new DisplayPlayerPoints(league, league.getPlayer(checkPlayerText.getText()));
            frame.dispose();
        });

        frame.setVisible(true);

    }


}




