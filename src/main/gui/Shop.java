package gui;

import exceptions.CannotBuyException;
import model.Item;
import model.Player;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
//Shop when player clicks on Buy in Decision menu
//Citation: https://www.youtube.com/watch?v=5o3fMLPY7qY

public class Shop {

    private JLabel balance;
    private JLabel inventory;

//    File oofFile = new File("res/oof.wav");
//    AudioClip sound;

    Item soe = new Item(300, 50, "The Sin of Envy", true);
    Item sword = new Item(9000, 9000, "Sword", true);

    //EFFECTS: Sets up frame and panel for Buy menu based on given player
    public Shop(Player player) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setTitle("shop");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1500, 750);

        JButton item1 = new JButton("Sin of Envy [Cost: 300/Stats: 50]");
        JButton item2 = new JButton("Sword [Cost: 9000/Stats: 9000]");

        balance = new JLabel("Balance: " + player.getBalance());
        inventory = new JLabel(player.displayItems());

        panelSetup(frame, item1, item2);

        buySinOfEnvy(player, item1);
        buySword(player, item2, sword, "balance: ");


    }

    //EFFECTS: Sets up panel
    private void panelSetup(JFrame frame, JButton item1, JButton item2) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setPreferredSize(new Dimension(1500, 750));
        panel.add(item1);
        panel.add(item2);
        panel.add(balance);
        panel.add(inventory);

        frame.add(panel);
    }
    //MODIFIES: player
    //EFFECTS: sets up functionality when sword is bought

    private void buySword(Player player, JButton item2, Item sword, String s) {
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    player.buyItem(sword);
                    Sound.playSound("oof");
                    balance.setText(s + player.getBalance());
                    inventory.setText(player.displayItems());
                } catch (CannotBuyException ex) {
                    balance.setText("The item cannot be bought!");

                }

            }
        });
    }

    //MODIFIES: player
    //EFFECTS: sets up functionality when Sin of Envy is bought
    private void buySinOfEnvy(Player player, JButton item1) {
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    player.buyItem(soe);
                    Sound.playSound("oof");
                    balance.setText("Balance: " + player.getBalance());
                    inventory.setText(player.displayItems());
                } catch (CannotBuyException ex) {
                    balance.setText("The item cannot be bought!");
                }


            }
        });
    }


}
