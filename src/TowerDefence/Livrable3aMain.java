package TowerDefence;

import TowerDefence.board.BoardOne;

/**
 * Main class for Livrable 3a.
 *
 * This class starts the Tower Defense game.
 * It reads command-line arguments, creates the game board,
 * initializes the game, and launches it.
 */
public class Livrable3aMain {
    /**
     * constructor
     */
    public Livrable3aMain(){};

    /**
     * Entry point of the program.
     *
     * Expected arguments:
     * args[0] → board width
     * args[1] → board height
     * args[2] → number of balloons
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
        int nbBallons = Integer.parseInt(args[2]);


        // Create the game board
        BoardOne board = new BoardOne(height, width);

        // Create the game with the given board and number of balloons
        Game game1 = new Game1(board, nbBallons);

        // Start the game
        game1.play();
    }
}