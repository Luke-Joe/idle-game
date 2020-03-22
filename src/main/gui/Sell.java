package gui;

import model.Item;
import model.Player;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Sell {
    public Sell(Player player) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setTitle("Sell");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1500, 750);

        JLabel balance = new JLabel("Balance: " + player.getBalance());
        JLabel inv = new JLabel(player.displayItems());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setPreferredSize(new Dimension(1500, 750));
        panel.add(balance);
        panel.add(inv);


        frame.add(panel);

        generateButtonsForInv(player, balance, inv, panel);
    }

    private void generateButtonsForInv(Player player, JLabel balance, JLabel inv, JPanel panel) {
        for (Item i : player.getInv()) {
            JButton temp = new JButton(i.getName());
            panel.add(temp);

            temp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.sellItem(i);
                    balance.setText("Balance: " + player.getBalance());
                    inv.setText(player.displayItems());
                    panel.remove(temp);

                }
            });

        }
    }


}
