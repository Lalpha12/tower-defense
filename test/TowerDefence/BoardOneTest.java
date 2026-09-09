package TowerDefence;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import TowerDefence.board.*;
/**
 * Unit tests for the BoardOne class.
 */
public class BoardOneTest {
   
    @Test
    public void testConstructor() {
        BoardOne board = new BoardOne(10, 15);

        assertEquals(10, board.getNbLigne(), "Number of rows should be 10");
        assertEquals(15, board.getNbColonne(), "Number of columns should be 15");
    }

    @Test
    public void testPathNotNull() {
        BoardOne board = new BoardOne(10, 10);
        ArrayList<Position> path = board.path(board.getBoard());

        assertNotNull(path, "Generated path should not be null");
    }

    @Test
    public void testPathNotEmpty() {
        BoardOne board = new BoardOne(10, 10);
        ArrayList<Position> path = board.path(board.getBoard());

        assertFalse(path.isEmpty(), "Generated path should not be empty");
    }

    @Test
    public void testPathPositionsAreInsideBoard() {
        BoardOne board = new BoardOne(8, 12);
        ArrayList<Position> path = board.path(board.getBoard());

        for (Position p : path) {
            assertTrue(p.getNbLigne() >= 0 && p.getNbLigne() < board.getNbLigne(),
                    "Position x should be inside board");
            assertTrue(p.getNbColonne() >= 0 && p.getNbColonne() < board.getNbColonne(),
                    "Position y should be inside board");
        }
    }
}
