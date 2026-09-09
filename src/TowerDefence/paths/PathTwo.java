package TowerDefence.paths;

import TowerDefence.board.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class implementing a straight path on a grid.
 * 
 * The path can be horizontal or vertical, starting from a random edge of the board.
 * Each cell in the path is marked with "x".
 */
public class PathTwo implements Path {

    /**
     * Constructs a PathTwo instance.
     */
    public PathTwo() {
        super();
    }

    /**
     * Generates a straight path on the given grid of cells.
     * 
     * Algorithm:
     * 1. Randomly choose whether the path is horizontal or vertical.
     * 2. If horizontal:
     *    - Randomly choose a row.
     *    - Randomly choose entry direction (left-to-right or right-to-left).
     *    - Mark all cells along that row in the chosen direction.
     * 3. If vertical:
     *    - Randomly choose a column.
     *    - Randomly choose entry direction (top-to-bottom or bottom-to-top).
     *    - Mark all cells along that column in the chosen direction.
     * 4. Each cell in the path is marked with "x" using Cell.setvalueX("x").
     * 
     * @param cells a 2D array of cells representing the board/grid
     * @return an ArrayList of Positions representing the generated path
     */
    @Override
    public ArrayList<Position> findPath(Cell[][] cells) {

        ArrayList<Position> listPath = new ArrayList<>();
        Random rand = new Random();
        int nbLigne = cells.length;
        int nbColonne = cells[0].length;

        // Randomly choose path orientation: 0 = horizontal, 1 = vertical
        int choice = rand.nextInt(2);

        if (choice == 0) { // horizontal path
            int ligne = rand.nextInt(nbLigne); // row of entry
            int alea = rand.nextInt(2); // entry from left (0) or right (1)

            if (alea == 0) { // left to right
                for (int col = 0; col < nbColonne; col++) {
                    Cell c = cells[ligne][col];
                    listPath.add(c.getPosition());
                }
            } else { // right to left
                for (int col = nbColonne - 1; col >= 0; col--) {
                    Cell c = cells[ligne][col];
                    listPath.add(c.getPosition());
                }
            }

        } else { // vertical path
            int colonne = rand.nextInt(nbColonne); // column of entry
            int alea = rand.nextInt(2); // entry from top (0) or bottom (1)

            if (alea == 0) { // top to bottom
                for (int lig = 0; lig < nbLigne; lig++) {
                    Cell c = cells[lig][colonne];
                    listPath.add(c.getPosition());
                }
            } else { // bottom to top
                for (int lig = nbLigne - 1; lig >= 0; lig--) {
                    Cell c = cells[lig][colonne];
                    listPath.add(c.getPosition());
                }
            }
        }

        return listPath;
    }
}

    
        

        
    

    
    



   

