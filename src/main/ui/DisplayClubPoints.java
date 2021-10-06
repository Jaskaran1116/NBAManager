package ui;

import model.Club;
import model.League;
import model.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DisplayClubPoints extends JFrame {
    League league;
    Club club;
    JPanel panel = new JPanel();
    JTable table;
    DefaultTableModel tableModel;

    JButton backButton = new JButton("Go back to the menu");

    DisplayClubPoints(League league, Club club) {
        super("Club points");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(new Dimension(450, 300));
        setResizable(false);
        this.league = league;
        this.club = club;

        displayClubPoints();


        panel.setLayout(null);

        backButton.addActionListener(e -> {

            new LaunchMenuPage(league);

        });

    }

    //EFFECTS: Displays the club points
    private void displayClubPoints() {
        String[] columnNames = {"Points"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        ArrayList<Integer> pointsOutput = new ArrayList<>();
        pointsOutput.add(club.getAndSetTotalPoints());
        Object[] data = pointsOutput.toArray();
        tableModel.addRow(data);
        table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        table.setFillsViewportHeight(true);
        add(new JScrollPane(table));
    }
}
