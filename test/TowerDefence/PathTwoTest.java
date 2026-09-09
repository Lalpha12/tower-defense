package TowerDefence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import TowerDefence.board.*;
import TowerDefence.paths.*;

import java.util.ArrayList;

public class PathTwoTest {
   
    PathTwo path ;
     BoardTwo board ;
    @BeforeEach 
    public void before (){
        board = new BoardTwo(8, 6, 1);
        path = new PathTwo();

    }

    @Test
    public void testPathTwoCreatesStraightPath() {
        // Create a board 8x6
       

        // Generate the path
        ArrayList<Position> result = path.findPath(board.getBoard());

        // 1. Path must not be null or empty
        assertNotNull(result);
        assertFalse(result.isEmpty());

        // 2. Check if path is straight (same row OR same column)
        int x0 = result.get(0).getNbLigne();
        int y0 = result.get(0).getNbColonne();

        boolean sameRow = true;
        boolean sameColumn = true;

        for (Position p : result) {
            if (p.getNbLigne() != x0) sameRow = false;
            if (p.getNbColonne() != y0) sameColumn = false;
        }

        assertTrue(sameRow || sameColumn, "Path must be horizontal or vertical");

        // 3. Check that all cells in the path are marked with "x"
        for (Position p : result) {
            Cell c = board.getCell(p.getNbLigne(), p.getNbColonne());
            assertEquals(".", c.toString());
        }
    }
}
