package ui;

import model.League;
import model.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DisplayPlayerPoints extends JFrame {
    League league;
    JPanel panel = new JPanel();
    JTable table;
    DefaultTableModel tableModel;
    Player player;
    JButton backButton = new JButton("Go back to the menu");

    DisplayPlayerPoints(League league, Player player) {
        super("player points");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(new Dimension(450, 300));
        setResizable(false);
        this.league = league;
        this.player = player;

        displayPlayerPoints();


        panel.setLayout(null);

        backButton.addActionListener(e -> {

            new LaunchMenuPage(league);

        });

    }


    //EFFECTS: Displays the points of the player.
    private void displayPlayerPoints() {
        String[] columnNames = {"Points"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        ArrayList<Integer> pointsOutput = new ArrayList<>();
        pointsOutput.add(player.calculateFantasyPoints());
        Object[] data = pointsOutput.toArray();
        tableModel.addRow(data);
        table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        table.setFillsViewportHeight(true);
        add(new JScrollPane(table));
    }
}




