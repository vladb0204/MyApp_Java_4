package com.company;

import java.util.*;

public class GameProcess extends TicTacToe {

    public Scanner sc = new Scanner(System.in);
    public StartGame start = new StartGame();
    public TicTacToe tictactoe = new TicTacToe();

    public void gameProcess() {
        start.Game();
        while (true) {
            System.out.println(start.player_1 + " moves");
            checkWinner();
            if (checkMoves()) break;

            System.out.println(start.player_2 + " moves");
            checkWinner();
            if (checkMoves()) break;
        }
    }

    public void repeatProcess() {
        tictactoe.resetProcess();
        while (true) {
            System.out.println();
            System.out.println(start.player_1 + " moves");
            tictactoe.insertMove();
            tictactoe.printTable();
            System.out.println();
            System.out.println(start.player_2 + " moves");
            tictactoe.insertMove();
            tictactoe.printTable();
            tictactoe.getWinner();
            if (checkMoves()) {
                break;
            }
        }
    }

    private boolean checkMoves() {
        if (!tictactoe.check) {
            System.out.println("Nice game! Wanna play again?");
            System.out.print("Enter [y/n]: ");
            if (sc.nextLine().equals("y")) {
                scorePrint();
                repeatProcess();
            } else {
                System.out.println("Program executed");
                return true;
            }
        }
        return false;
    }

    public void scorePrint() {
        System.out.println("Scores are: ");
        System.out.println(start.player_1 + ": " + tictactoe.score_x);
        System.out.println(start.player_2 + ": " + tictactoe.score_o);
        System.out.println();
        start.printAvailableTable();
        System.out.println();
    }

    private void checkWinner() {
        tictactoe.insertMove();
        tictactoe.getWinner();
    }
}
