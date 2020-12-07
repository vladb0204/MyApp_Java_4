package com.company;

import java.util.*;

public class TicTacToe extends Main {

    public Scanner sc = new Scanner(System.in);
    public StartGame start = new StartGame();

    public boolean check = true;
    public int move = 0;
    public String[] cells = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    public String[] available_cells = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
    public String move_in = "X";
    public int score_x = 0;
    public int score_o = 0;


    public void resetProcess() {
        check = true;
        move_in = "X";

        for (int i = 0; i < 9; i++) {
            cells[i] = " ";
            available_cells[i] =  Integer.toString(i + 1);
        }
    }

    public void insertMove() {
        int left_space = 0;
        int[] available = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < 9; i++) {
            if (cells[i].equals(" ")) {
                left_space += 1;
                available[i] = 1;
            }
        }

        if (left_space == 0) {
            getWinner();
        } else {
            System.out.print("Available cells: ");
            for (int i = 0; i < 9; i++) {
                if (available[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            printTable();

            if (move_in.equals("X")) {
                getMove("X");
                move_in = "O";
            } else {
                getMove("O");
                move_in = "X";
            }
        }
    }

    public void printTable() {
        System.out.println("---------");
        System.out.println("| " + available_cells[0] + " " + available_cells[1] + " " + available_cells[2] + " |");
        System.out.println("| " + available_cells[3] + " " + available_cells[4] + " " + available_cells[5] + " |");
        System.out.println("| " + available_cells[6] + " " + available_cells[7] + " " + available_cells[8] + " |");
        System.out.println("---------");
    }

    public void getWinner() {
        int count_o = 0;
        int count_x = 0;
        int count_space = 0;

        for (String elem: cells) {
            switch (elem) {
                case "X" -> count_x += 1;
                case "O" -> count_o += 1;
                case " " -> count_space += 1;
            }
        }

        if (count_space != 0) {
            checkCoords(0);
        } else {
            checkCoords(1);
        }
    }

    private void checkCoords(int option) {
        int[][] win_coord = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
                {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        if (option == 0) {

            for (int[] elem : win_coord) {
                if (cells[elem[0]].equals(cells[elem[1]]) && cells[elem[1]].equals(cells[elem[2]])
                        && cells[elem[0]].equals(cells[elem[2]]) && !cells[elem[0]].equals(" ")) {
                    printTable();
                    System.out.println(cells[elem[0]] + " has won!!!");
                    if (cells[elem[0]].equals("X")) {
                        score_x += 1;
                    } else {
                        score_o += 1;
                    }
                    check = false;
                    break;
                }
            }
        } else {

            int count_equals = 0;

            for (int[] elem : win_coord) {
                if (cells[elem[0]].equals(cells[elem[1]]) && cells[elem[1]].equals(cells[elem[2]])
                        && cells[elem[0]].equals(cells[elem[2]]) && !cells[elem[0]].equals(" ")) {
                    printTable();
                    count_equals += 1;
                    System.out.println(cells[elem[0]] + " has won!!!");
                    if (cells[elem[0]].equals("X")) {
                        score_x += 1;
                    } else {
                        score_o += 1;
                    }
                    check = false;
                    break;
                }
            }

            if (count_equals == 0) {
                printTable();
                System.out.println("Draw");
                check = false;
            }
        }
    }

    private void getMove(String move_in) {
        try {
            move = sc.nextInt();
        }
        catch (InputMismatchException exception) {
            System.out.println("You should input only numbers!!!");
            getMove(move_in);
        }
        checkMove(move, move_in);
    }

    private void checkMove(int move_input, String input_cell) {

        if (move_input < 0 || move_input > 8) {
            System.out.println("I can input numbers only from 0 to 8");
            getMove(input_cell);
        } else if (!(cells[move_input].equals(" "))) {
            System.out.println("You can't input it here! This cell is occupied");
            getMove(input_cell);
        } else {
            cells[move_input] = input_cell;
            available_cells[move_input] = input_cell;
        }

    }
}
