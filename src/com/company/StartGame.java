package com.company;

import java.util.*;

public class StartGame {

    public String player_1 = "";
    public String player_2 = "";
    public Scanner sc = new Scanner(System.in);

    public String[] available_cells = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};

    public void Game() {
        System.out.println("Hello there! Lets start the game!");
        System.out.print("First player name: ");
        player_1 = sc.nextLine();
        System.out.print("Second player name: ");
        player_2 = sc.nextLine();
        System.out.println("This is how you need to input X or O in cells");
        printAvailableTable();
    }

    public void printAvailableTable() {
        System.out.println("---------");
        System.out.println("| " + available_cells[0] + " " + available_cells[1] + " " + available_cells[2] + " |");
        System.out.println("| " + available_cells[3] + " " + available_cells[4] + " " + available_cells[5] + " |");
        System.out.println("| " + available_cells[6] + " " + available_cells[7] + " " + available_cells[8] + " |");
        System.out.println("---------");
    }
}
