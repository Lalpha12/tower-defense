package TowerDefence;

import TowerDefence.board.BoardTwo;

/**
 * Main class for Livrable 3b.
 *
 * This class starts the Tower Defense game
 * using a board with multiple paths.
 * It reads command-line arguments, creates the board,
 * initializes the game, and launches it.
 */
public class Livrable3bMain {
    /**
     * constructor
     */
    public Livrable3bMain(){

    };

    /**
     * Entry point of the program.
     *
     * Expected arguments:
     * args[0] → board height
     * args[1] → board width
     * args[2] → number of paths
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Check if the correct number of arguments is provided
        if (args.length != 3) {
            System.out.println(
                "Usage : java Livrable3b <height> <width> <number_of_paths>"
            );
            return;
        }

        // Read command-line arguments
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int nPaths = Integer.parseInt(args[2]);

        // Create the game board with multiple paths
        BoardTwo board = new BoardTwo(height, width, nPaths);

        // Create the game with the given board and number of paths
        Game game1 = new Game1(board, nPaths);

        // Start the game
        game1.play();
    }
}