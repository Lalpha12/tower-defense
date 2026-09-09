package TowerDefence.paths;

import TowerDefence.board.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class generates a simple random path on a grid.
 * 
 * The path starts from a random entry row, moves horizontally until a
 * turning column, then moves vertically towards a random exit row, 
 * and finally continues horizontally to the end of the board.
 * Each cell in the path is marked with an "x".
 */
public class PathOne implements Path {

    /**
     * Constructs a PathOne instance.
     */
    public PathOne() {
        super();
    }

    /**
     * Generates a sorted list of unique random turning columns.
     * Each column represents a point where the path will change
     * from horizontal to vertical movement.
     *
     * @param cells the grid of cells
     * @return an ArrayList of column indices where turns occur
    */
    public ArrayList<Integer> lTurnings(Cell[][] cells) {

        Random rand = new Random();
        int nbColonne = cells[0].length;

        // Number of turns is limited to half the board width
        int turning;
        do {
            turning = rand.nextInt(nbColonne / 2);
        } while (turning == 0);

        ArrayList<Integer> lTurning = new ArrayList<>();

        // Generate unique random columns
        for (int i = 0; i < turning; i++) {
            int j = rand.nextInt(nbColonne);
            while (lTurning.contains(j)) {
                j = rand.nextInt(nbColonne);
            }
            lTurning.add(j);
        }

        // Sort columns in ascending order to ensure forward movement
        Collections.sort(lTurning);
        return lTurning;
    }
    /**
     * Moves horizontally on a given row from column deb to fin.
     * Each visited cell is added to the path and marked with "x".
     *
     * @param deb   starting column
     * @param fin   ending column
     * @param ligne row index
     * @param cells grid of cells
     * @param l     list storing the path positions
     */
    public void horizontal(int deb, int fin, int ligne, Cell[][] cells, ArrayList<Position> l) {
        for (int i = deb; i <= fin; i++) {
            Cell c = cells[ligne][i];
            l.add(c.getPosition());
        }
    }

    /**
     * Moves vertically in a given column from row deb to fin.
     * Handles both upward and downward movement.
     *
     * @param deb   starting row
     * @param fin   ending row
     * @param col   column index
     * @param cells grid of cells
     * @param l     list storing the path positions
     */
    public void vertical(int deb, int fin, int col, Cell[][] cells, ArrayList<Position> l) {

        // Move down
        if (deb < fin) {
            for (int j = deb + 1; j <= fin; j++) {
                Cell c = cells[j][col];
                l.add(c.getPosition());
            }
        }
        // Move up
        else {
            for (int j = deb - 1; j >= fin; j--) {
                Cell c = cells[j][col];
                l.add(c.getPosition());
            }
        }
    }


    /**
     * Generates a random path on the given grid.
     *
     * Algorithm:
     * 1. Choose a random starting row at column 0.
     * 2. Generate a list of turning columns.
     * 3. For each turning column:
     *    - Move horizontally to the column.
     *    - Choose a new random row.
     *    - Move vertically to that row.
     * 4. Finish with a horizontal move to the last column.
     *
     * @param cells a 2D array representing the board
     * @return an ArrayList of Positions representing the path
    */
    @Override
    public ArrayList<Position> findPath(Cell[][] cells) {

        Random rand = new Random();
        int nbLigne = cells.length;
        int nbColonne = cells[0].length;

        // Random entry and exit rows
        int currentRow = rand.nextInt(nbLigne);
        int currentCol = 0;

        
        ArrayList<Position> l = new ArrayList<>();
        ArrayList<Integer> lTurning = this.lTurnings(cells);

        // If no turns are generated, go straight horizontally
        if (lTurning.isEmpty()) {
            horizontal(0, nbColonne - 1, currentRow, cells, l);
            return l;
        }

        for (int i = 0; i < lTurning.size(); i++) {

            int turnCol = lTurning.get(i);

            // Horizontal movement to the turning column
            horizontal(currentCol, turnCol, currentRow, cells, l);
            currentCol = turnCol;

            // Choose a different row
            int nextRow;
            do {
                nextRow = rand.nextInt(nbLigne);
            } while (nextRow == currentRow);

            // Vertical movement
            vertical(currentRow, nextRow, currentCol, cells, l);
            currentRow = nextRow;
        }

        // Final horizontal movement to the end of the board
        if (currentCol < nbColonne - 1) {
            horizontal(currentCol + 1, nbColonne - 1, currentRow, cells, l);
        }

        return l;
    }
}

