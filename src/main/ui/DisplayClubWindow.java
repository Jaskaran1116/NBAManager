package ui;

import model.Club;
import model.League;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DisplayClubWindow extends JFrame {
    League league;
//    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTable table;
    DefaultTableModel tableModel;
    JButton backButton = new JButton("Go back to the menu");

    DisplayClubWindow(League league) {
        super("List of clubs in the league");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(new Dimension(450, 300));
        setResizable(false);
        this.league = league;

        displayClubs();

//        frame.setSize(900, 600);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        panel.setLayout(null);

        backButton.addActionListener(e -> {
//            frame.dispose();
            new LaunchMenuPage(league);

        });
//        frame.setVisible(true);
    }

    //EFFECTS: Displays the list of clubs in the league
    private void displayClubs() {
        String[] columnNames = {"Name"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        for (Club club : league.getClubs()) {
            ArrayList<String> output = new ArrayList<>();
            output.add(club.getClubName());
            Object[] data = output.toArray();
            tableModel.addRow(data);
        }
        table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        table.setFillsViewportHeight(true);
        add(new JScrollPane(table));

    }


}
