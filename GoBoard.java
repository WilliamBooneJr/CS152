//This program creates a 19x19 Go board and prints to terminal. 
//It also places two pieces on the board and re-prints it.
//The goal of the game is to surround more territory than the opponent.
//The game is played on a grid of black lines (usually 19×19). Game pieces are called stones.
//One player uses white stones and the other, black. Players take turns placing a stone of their color on a point.
//A stone must be placed on an intersection of the lines, not on the squares.
//A stone must not be placed on a point where it would be immediately captured.
//The program creates the board and places two pieces on it.
//The program then prints the board to the terminal.
//The program uses a 2D array to represent the board and uses strings to represent the pieces.
//The program takes turns prompting the user to place a piece on the board.
//The program checks if the move is valid and then places the piece on the board.
//The program then checks if the move captures any pieces and removes them from the board.

import java.util.Scanner;


public class GoBoard {

    public static void main(String[] args) {
        // Initialize a 19x19 2D array to represent the Go board
        String[][] goBoard = new String[19][19];

        // Initialize the board with spaces and print it
        initializeBoard(goBoard);
        printBoard(goBoard);


        promptForMove(goBoard, "◯"); // White move
        printBoard(goBoard);
        promptForMove(goBoard, "●"); // Black move
        printBoard(goBoard);
        
        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

    
    // Close the Scanner to avoid resource leaks
        sc.close();
        

        goBoard[9][9] = "◯"; // White piece
        goBoard[9][8] = "●"; // Black piece

        // Re-print the board after setting the pieces
        System.out.println("After placing two pieces:");
        printBoard(goBoard);
    }

    private static void initializeBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "_"; // Use underscore for empty spaces
            }
        }
    }

    private static void printBoard(String[][] board) {
        // Print column coordinates
        System.out.print("  ");
        for (int i = 0; i < board.length; i++) {
            System.out.print((i + 1) % 10 + "  "); // Print column numbers, reset every 10
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            // Print row coordinate
            System.out.print((i + 1) % 10 + " "); // Print row numbers, reset every 10

            for (int j = 0; j < board[i].length; j++) {
                System.out.print("|" + board[i][j] + " "); // Use vertical bar to separate spaces
            }
            System.out.println("|");
        }
    }
    private static void promptForMove(String[][]board, String piece) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player " + piece + ", enter row and column numbers (1-19) to place your piece: ");
        int row = sc.nextInt() - 1; // Subtract 1 for zero-based indexing
        int column = sc.nextInt() - 1;
    
    // Validate the move
    if (row >= 0 && row < board.length && column >= 0 && column < board[row].length && board[row][column].equals("_")) {
        board[row][column] = piece;
        System.out.println("Piece placed.");
    } else {
        System.out.println("Invalid move. Try again.");
        promptForMove(board, piece); // Recursively prompt for a valid move
    }}

}