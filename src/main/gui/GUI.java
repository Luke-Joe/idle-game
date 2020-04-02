package gui;

import model.Player;
import persistence.Writer;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

// Main menu for game
// Citation: https://www.youtube.com/watch?v=5o3fMLPY7qY
public class GUI {
    private JButton button;
    private JButton shop;
    private JButton save;
    private JLabel minions;
    private JLabel money;
    private JPanel midPanel;
    private JPanel leftPanel;
    Player player1;

    // Sets up menu
    public GUI(Player player, String id) {

        player1 = player;
        button = new JButton("Minion");
        shop = new JButton("Shop");
        save = new JButton("Save");
        shop.setPreferredSize(new Dimension(100, 100));
        minions = new JLabel("Slain: " + player1.getCs());
        money = new JLabel("Balance: " + player1.getBalance());
        button.setPreferredSize(new Dimension(450, 600));
        clickButton();
        clickShop();
        leftPanel();
        midPanel();
        frameSetup();

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Writer.savePlayer(player1, id);
                } catch (IOException i) {
                    i.printStackTrace();
                }

            }
        });


    }

    //EFFECTS: Sets functionality when "Shop" button is clicked
    private void clickShop() {
        shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Decision(player1);
            }
        });
    }

    //EFFECTS: Sets up left panel
    private void leftPanel() {
        leftPanel = new JPanel();
        leftPanel.setBorder(BorderFactory.createEmptyBorder(350, 100, 350, 500));
        leftPanel.add(shop);
        leftPanel.add(save);

    }

    //EFFECTS: Sets up middle panel
    private void midPanel() {
        midPanel = new JPanel();
        midPanel.setBorder(BorderFactory.createEmptyBorder(150, 350, 500, 700));
        midPanel.add(button);
        midPanel.add(minions);
        midPanel.add(money);
    }

    //EFFECTS: Sets up frame
    private void frameSetup() {
        JFrame frame = new JFrame();
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(midPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lucas Farming Simulator");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1500, 1000);
    }

    //MODIFIES: player
    //EFFECTS: Sets up functionality when minion is clicked

    private void clickButton() {
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player1.onKill();
                        minions.setText("Slain: " + player1.getCs());
                        money.setText("Balance: " + player1.getBalance());


                    }
                }
        );
    }


}

