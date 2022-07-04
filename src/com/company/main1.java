package com.company;

import java.util.Objects;
import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //new

        System.out.println("player 1,please enter your name:");
        String p1 = scanner.next();
        System.out.println("player 2,please enter your name:");
        String p2 = scanner.next();

        //Board
        String[][] board = new String[3][3];

        //Draw Board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = " ";
            }
        }

        boolean thePlayer1 = true;

        //when the game ended
        boolean theGameEnded = false;

        while (!theGameEnded) {
            drawBoard(board);


            String symbol = " ";
            if (thePlayer1) {
                symbol = "X";
            } else {
                symbol = "O";
            }

            if (thePlayer1) {
                System.out.println(p1 + "'s turn (X)");
            } else {
                System.out.println(p2 + "'s turn (O)");
            }

            int row = 0;
            int col = 0;


            while (true) {
                System.out.println("enter the row (0-2):");
                row = scanner.nextInt();
                System.out.println("enter the col (0-2):");
                col = scanner.nextInt();


                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("Row or col are out of the bounds!!!");
                } else if (!Objects.equals(board[row][col], " ")) {
                    System.out.println("its used before...!!!");
                } else {
                    break;
                }
            }

            board[row][col] = symbol;

            if (theWining(board) == "X") {
                System.out.println(p1 + "Has Won!!!");
                theGameEnded = true;
            } else if (theWining(board) == "O") {
                System.out.println(p2 + "Has Won!!!");
                theGameEnded = true;
            } else {
                if (hasFull(board)) {
                    System.out.println("The Board is Full!!!");
                    theGameEnded = true;
                }else {
                    thePlayer1=!thePlayer1;
                }
            }
        }
        //Print the final State of Board
        drawBoard(board);

    }


    public static void drawBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("|");
                System.out.print(board[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static String theWining(String[][] board) {
        //Row
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] !=" ") {
                return board[i][0];
            }
        }
        //col
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != " ") {
                return board[0][j];
            }
        }
        //Diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != " ") {
            return board[0][0];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != " ") {
            return board[2][0];
        }
        //if nobody has won
        return " ";
    }

    //if the Board is full and nobody has won the game
    public static boolean hasFull(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == " ") {
                    return false;
                }
            }
        }
        return true;
    }
}


































































