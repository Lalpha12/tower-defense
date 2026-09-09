package TowerDefence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import TowerDefence.board.*;

/**
 * Unit tests for the BoardTwo class.
 */
public class BoardTwoTest {

    @Test
    public void testConstructor() {
        BoardTwo board = new BoardTwo(10, 12, 3);

        assertEquals(10, board.getNbLigne(), "Number of rows should be 10");
        assertEquals(12, board.getNbColonne(), "Number of columns should be 12");
    }

    @Test
    public void testPathNotNull() {
        BoardTwo board = new BoardTwo(10, 10, 2);
        ArrayList<ArrayList<Position>> paths = board.path(board.getBoard());

        assertNotNull(paths, "Paths list should not be null");
    }

    @Test
    public void testNumberOfPaths() {
        int n = 4;
        BoardTwo board = new BoardTwo(10, 10, n);
        ArrayList<ArrayList<Position>> paths = board.path(board.getBoard());

        assertEquals(n, paths.size(), "Number of generated paths should match nPaths");
    }

    @Test
    public void testEachPathNotEmpty() {
        BoardTwo board = new BoardTwo(10, 10, 3);
        ArrayList<ArrayList<Position>> paths = board.path(board.getBoard());

        for (ArrayList<Position> path : paths) {
            assertFalse(path.isEmpty(), "Each path should not be empty");
        }
    }

    @Test
    public void testPathPositionsInsideBoard() {
        BoardTwo board = new BoardTwo(8, 15, 3);
        ArrayList<ArrayList<Position>> paths = board.path(board.getBoard());

        for (ArrayList<Position> path : paths) {
            for (Position p : path) {
                assertTrue(p.getNbLigne() >= 0 && p.getNbLigne() < board.getNbLigne(),
                        "Position x should be inside board");
                assertTrue(p.getNbColonne() >= 0 && p.getNbColonne() < board.getNbColonne(),
                        "Position y should be inside board");
            }
        }
    }
}
