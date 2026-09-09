package TowerDefence;


import TowerDefence.board.*;
import java.util.ArrayList;
/**
 * Classe principale permettant d'exécuter le livrable 1b.
 */
public class Livrable1bMain {
     /**
      * the default constructor for the documentation
      */
    public Livrable1bMain(){

    }
    /**
     *  we create the  board two
     * @param args string
     */
    public static void main(String[] args) {
        // Check for correct number of arguments
        if (args.length != 3) {
            System.out.println("Error: please provide 3 integers as arguments (height, width, number_of_paths).");
            return;
        }

        // Parse arguments
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int nPaths = Integer.parseInt(args[2]);
    

    // Create the board with multiple paths
        BoardTwo board = new BoardTwo(height, width, nPaths);
        ArrayList<ArrayList<Position>> paths = board.path(board.getBoard());

        // Display each path
        System.out.println("Chemins trouvés :");
        int index = 0;
        for (ArrayList<Position> chemin : paths) {
            System.out.println("Chemin " + index + " :");
            for (Position pos : chemin) {
                System.out.println(pos);
            }
            index++;
            System.out.println();
        }

        // Display the board with all paths marked
        System.out.println("Grille du plateau :");
        board.affiche();

    }
}
