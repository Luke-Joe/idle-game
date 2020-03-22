package gui;

import model.Player;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Decision {

    public Decision(Player player) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setTitle("Buy/Sell");

        frame.setSize(1500, 750);

        JButton buy = new JButton("Buy");
        JButton sell = new JButton("Sell");

        JLabel intro = new JLabel("Hello! What would you like to do?");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setPreferredSize(new Dimension(1500, 750));
        panel.add(buy);
        panel.add(sell);
        panel.add(intro);

        frame.add(panel);

        clickBuy(player, buy);
        clickSell(player, sell);

        frame.pack();
        frame.setVisible(true);

    }

    private void clickSell(Player player, JButton sell) {
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sell(player);
            }
        });
    }

    private void clickBuy(Player player, JButton buy) {
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Shop(player);
            }
        });
    }



}
