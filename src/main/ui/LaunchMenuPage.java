package ui;

import model.League;
import persistence.JsonReader;
import persistence.JsonWriter;
import sun.rmi.runtime.NewThreadAction;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class LaunchMenuPage implements ActionListener {

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/myLeague.json";

    JFrame frame = new JFrame();
    League league;
    JLabel taskLabel = new JLabel("WHAT DO YOU WANT TO DO TODAY !!!");
    JButton createClubButton = new JButton("Create a new Club ");
    JButton addPlayerButton = new JButton("Add a Player to a club ");
    JButton displayClubButton = new JButton("Display the clubs in the league ");
    JButton playerPointsButton = new JButton("Show Player's Points ");
    JButton clubPointsButton = new JButton("Show Club points ");
    JButton saveLeagueButton = new JButton("Save the league ");
    JButton loadLeagueButton = new JButton("Load the league ");

    LaunchMenuPage(League league) {
        this.league = league;
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        createClubButton.setBounds(180, 160, 500, 25);
        createClubButton.setFocusable(false);
        createClubButton.addActionListener(this);
        frame.add(createClubButton);
        frame.setTitle("THIS IS THE NBA MENU !!!");

        taskLabel.setBounds(180, 50, 400, 100);
        frame.add(taskLabel);

        button2Helper(addPlayerButton);
        button4Helper(displayClubButton);
        button5Helper(playerPointsButton);
        button6Helper(clubPointsButton);
        button7Helper(saveLeagueButton);
        button8Helper(loadLeagueButton);
        frameHelper();

    }

    private void button7Helper(JButton myButton7) {
        myButton7.setBounds(180, 310, 500, 25);
        myButton7.setFocusable(false);
        myButton7.addActionListener(this);
        frame.add(saveLeagueButton);
    }

    private void button6Helper(JButton myButton6) {
        myButton6.setBounds(180, 280, 500, 25);
        myButton6.setFocusable(false);
        myButton6.addActionListener(this);
        frame.add(clubPointsButton);
    }

    private void button5Helper(JButton myButton5) {
        myButton5.setBounds(180, 250, 500, 25);
        myButton5.setFocusable(false);
        myButton5.addActionListener(this);
        frame.add(playerPointsButton);
    }

    private void button4Helper(JButton myButton4) {
        myButton4.setBounds(180, 220, 500, 25);
        myButton4.setFocusable(false);
        myButton4.addActionListener(this);
        frame.add(displayClubButton);
    }

    private void button2Helper(JButton myButton2) {
        myButton2.setBounds(180, 190, 500, 25);
        myButton2.setFocusable(false);
        myButton2.addActionListener(this);
        frame.add(addPlayerButton);
    }

    private void button8Helper(JButton myButton8) {
        myButton8.setBounds(180, 340, 500, 25);
        myButton8.setFocusable(false);
        myButton8.addActionListener(this);
        frame.add(loadLeagueButton);

    }

    private void frameHelper() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLayout(null);
        addPlayerButton.addActionListener(this::actionPerformedButton2);
        playerPointsButton.addActionListener(this::actionPerformedButton5);
        clubPointsButton.addActionListener(this::actionPerformedButton6);
        saveLeagueButton.addActionListener(this::actionPerformedButton7);
        displayClubButton.addActionListener(this::actionPerformedButton4);
        loadLeagueButton.addActionListener(this::actionPerformedButton8);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createClubButton) {
            frame.setVisible(false);
            new NewClubWindow(league);
            createSoundEffect();


        }
    }

    public void actionPerformedButton2(ActionEvent e) {
        if (e.getSource() == addPlayerButton) {
            new NewPlayerWindow(league);
            createSoundEffect();
        }
    }

    public void actionPerformedButton4(ActionEvent e) {
        if (e.getSource() == displayClubButton) {
            new DisplayClubWindow(league);
            createSoundEffect();
        }
    }

    public void actionPerformedButton5(ActionEvent e) {
        if (e.getSource() == playerPointsButton) {
            new PlayerPointsWindow(league);
            createSoundEffect();
        }
    }


    public void actionPerformedButton6(ActionEvent e) {
        if (e.getSource() == clubPointsButton) {
            new ClubPointsWindow(league);
            createSoundEffect();
        }
    }

    //EFFECTS: Saves the league from the menu page
    public void actionPerformedButton7(ActionEvent e) {
        if (e.getSource() == saveLeagueButton) {
            saveLeague();
            createSoundEffect();
        }
    }

    //EFFECTS: Loads the league from the menu page
    public void actionPerformedButton8(ActionEvent e) {
        if (e.getSource() == loadLeagueButton) {
            loadLeague();
            createSoundEffect();
        }
    }



    //EFFECTS: creates a sound effect on pressing a button
    public static void createSoundEffect() {
        File file = new File("C:\\bloop_x.wav");
        Clip clip;
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
        } catch (Exception e) {
            System.out.println("Couldn't play audio");
        }
    }

    //EFFECTS: Saves the league to file
    private void saveLeague() {
        try {
            jsonWriter.open();
            jsonWriter.write(league);
            jsonWriter.close();
            System.out.println("Saved " + league.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }

    }

    // MODIFIES: this
    // EFFECTS: loads league from file
    private void loadLeague() {
        try {
            league = jsonReader.read();
            System.out.println("Loaded " + league.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
