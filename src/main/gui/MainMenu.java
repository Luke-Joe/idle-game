package gui;

import model.Player;
import org.json.simple.parser.ParseException;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static persistence.Reader.parseSave;
import static persistence.Reader.readPlayer;
import static persistence.Writer.savePlayer;
//Menu in which player can choose to load or create a new save
//Citation: https://www.youtube.com/watch?v=5o3fMLPY7qY

public class MainMenu {


    //EFFECTS: Sets up frame and panel for the Load/New menu
    public MainMenu() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Lucas Farming Simulator");

        JLabel intro = new JLabel("Welcome to Lucas Farming Simulator!");

        JButton newUser = new JButton("Create New User");
        JButton oldSave = new JButton("Load Save");

        JPanel panel = setupJPanel(intro, newUser, oldSave);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        clickNewUser(newUser);
        clickOldSave(oldSave);


    }

    private JPanel setupJPanel(JLabel intro, JButton newUser, JButton oldSave) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(intro);
        panel.add(newUser);
        panel.add(oldSave);
        return panel;
    }

    //EFFECTS: Sets up functionality when "Load" button is clicked
    private void clickOldSave(JButton oldSave) {
        oldSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int g = -1;
                while (g < 0) {
                    String input = JOptionPane.showInputDialog("Enter Username");
                    if (input.length() > 0) {
                        g++;
                        try {
                            new GUI(parseSave(readPlayer("./data/" + input + ".json")), input);
                        } catch (IOException ex) {
                            input = JOptionPane.showInputDialog("That file does not exist, enter another username");
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        input = JOptionPane.showInputDialog("Username's are > 0 characters long");
                    }

                }
            }
        });
    }

    //Sets up functionality when "New User" button is clicked
    private void clickNewUser(JButton newUser) {
        newUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int g = -1;
                while (g < 0) {
                    String input = JOptionPane.showInputDialog("Enter New Username");
                    if (input.length() > 0) {
                        g++;
                        try {
                            savePlayer(new Player(), input);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        readSave(input);
                    } else {
                        input = JOptionPane.showInputDialog("Username must be > 0 characters long");
                    }
                }
            }
        });
    }


    //Reads old save with given name
    private void readSave(String input) {
        try {
            new GUI(parseSave(readPlayer("./data/" + input + ".json")), input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

}
