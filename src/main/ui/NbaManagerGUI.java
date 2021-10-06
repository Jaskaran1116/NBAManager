package ui;

import model.League;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.text.DefaultCaret;

public class NbaManagerGUI implements ActionListener {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel welcomeLabel = new JLabel("WELCOME TO NBA MANAGEMENT SYSTEM !!!");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("NBA Management System!!!");

        panel.setLayout(null);

        JLabel label = new JLabel("User");
        label.setBounds(350, 250, 80, 25);
        panel.add(label);

        welcomeLabel.setBounds(350, 160, 300, 100);
        panel.add(welcomeLabel);

        JTextField userText = new JTextField();
        userText.setBounds(400, 250, 165, 25);
        panel.add(userText);

        JButton button = new JButton("Begin");
        button.setBounds(440, 300, 80, 25);
        button.addActionListener(new NbaManagerGUI());
        panel.add(button);

        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new LaunchMenuPage(new League("MyLeague"));
        System.out.println("Successful");
    }

}

