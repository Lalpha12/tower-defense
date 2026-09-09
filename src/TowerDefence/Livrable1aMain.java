package TowerDefence;
import TowerDefence.board.*;
import java.util.ArrayList;




/**
 * Main class for Livrable 1a.
 * 
 * This program creates a board with a single random path
 * starting from the left side and ending on the right side.
 */
public class Livrable1aMain {
     /**
      * the  default constructor
      */
    public Livrable1aMain(){} 
    /***
     * it's  the  main run the programme of the create the boardone 
     * @param args args 
     */
    public static void main(String[] args) {
        // Check for correct number of arguments
        if (args.length != 2) {
            System.out.println("Error: please provide 2 integers as arguments (height and width).");
            return;
        }

        // Parse arguments
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
                // Create a board with a single random path
        BoardOne board = new BoardOne(height, width);
        ArrayList<Position> path = board.path(board.getBoard());

        // Display the path coordinates
        System.out.println("Chemin trouvé :");
        for (Position pos : path) {
            System.out.println(pos);
        }

        // Display the board with the path marked
        System.out.println("\nGrille du plateau :");
        board.affiche();
      
}}
