package TowerDefence;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TowerDefence.board.*;
import TowerDefence.paths.*;

import java.util.ArrayList;

public class PathOneTest {

    @Test
    public void testPathOneCreatesAValidPath() {
        // Create a board 10x10
        BoardOne board = new BoardOne(10, 10);
        PathOne path = new PathOne();

        // Generate the path
        ArrayList<Position> result = path.findPath(board.getBoard());

        // 1. Path should not be null
        assertNotNull(result);

        // 2. Path should not be empty
        assertFalse(result.isEmpty());

        // 3. All positions in the path should correspond to cells marked with "x"
        for (Position p : result) {
            Cell c = board.getCell(p.getNbLigne(), p.getNbColonne());
            assertEquals(".", c.toString());
        }
    }
}
