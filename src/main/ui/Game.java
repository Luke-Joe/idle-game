package ui;

import model.Item;
import model.Player;

import java.sql.SQLOutput;
import java.util.Scanner;

import static model.Player.MAX_SIZE;

public class Game {
    private Scanner input;
    Player player = new Player();
    Item item1 = new Item(300, 5, "The Sin of Envy", true);
    Item item3 = new Item(0, 1, "Chicken", false);

    //EFFECTS: runs the game
    public Game() {
        runGame();
    }


    //MODIFIES: this
    //EFFECTS: processes user input
    private void runGame() {
        boolean running = true;
        String move;
        input = new Scanner(System.in);

        while (running) {
            mainMenu();
            move = input.next();

            if (move.equals("e")) {
                running = false;
                System.out.println("See you next time");
            } else if (move.equals("p")) {
                profile();
            } else if (move.equals("s")) {
                shop();

            } else if (move.equals("r")) {
                System.out.println("your balance has increased by " + ((player.getCs() / 10) * 10) + "!");
                player.balance = player.getBalance() + ((player.getCs() / 10) * 10);
                player.cs = player.getCs() + 1;

            } else {
                System.out.println("your command is invalid");
            }
        }
    }


    private void profile() {
        System.out.println("Your current balance is " + player.getBalance() + ".\n You are doing "
                + player.getAd() + " damage with each strike.\n Your team is doing " + player.getDmg()
                + " each second.\n"
                + "you have slain " + player.getCs() + " minions.");
//                + "You have used up slots in your inventory \n");

    }

    private void shop() {
        String selection = "";

        while (!(selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4"))) {

            System.out.println("Welcome to the store!\n The following items are on sale right now:\n"
                    + "(1) " + item1.getName() + " Stats: " + item1.getStats() + " Price: " + item1.getCost() + "\n"
                    + "(3) " + item3.getName() + " Stats: " + item3.getStats() + " Price: " + item3.getCost() + "\n");

            System.out.println("Type the number to the left to buy the item!");
            selection = input.next();

            if (selection.equals("1")) {
                if (player.buyItem(item1)) {
                    System.out.println("You have bought " + item1.getName());
                } else {
                    System.out.println("You cannot purchase this item");
                }
            } else if (selection.equals("3")) {
                if (player.buyItem(item3)) {
                    System.out.println("You have bought " + item3.getName());
                } else {
                    System.out.println("You cannot purchase this item");
                }
            }
        }
    }


    private void mainMenu() {
        System.out.println("Welcome to LucasFarmingSimulator");
        System.out.println("type r to hit the minion");
        System.out.println("type s to enter the shop");
        System.out.println("type p to view your profile");
        System.out.println("type e to exit the game");
    }
}

