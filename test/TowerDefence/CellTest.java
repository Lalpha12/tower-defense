package TowerDefence;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TowerDefence.Balloon.BasicBalloon;
import TowerDefence.board.*;
public class CellTest {
    private  Cell c;
    private  Cell c1;
    private  Cell c2;
    private  Cell c3;
    @BeforeEach
    public void before(){
        this.c=new Cell(new Position(1, 2));
        this.c1 = new Cell(new Position(1, 2));
        this.c2 = new Cell(new Position(1, 2));
        this.c3 = new Cell(new Position(2, 1));
    }

 @Test
    void testGetters() {
        Cell c = new Cell(new Position(1, 2));
        assertEquals(1, c.getPosition().getNbLigne());
        assertEquals(2, c.getPosition().getNbColonne());

        // valeur par défaut
        assertEquals(".", c.toString());

        // valeur après affectation
        c.setvalueX(new BasicBalloon(1f, 1, "b"));
        assertEquals("X", c.toString());
    }

    @Test
    void testEquals() {
       
        assertEquals(c1, c2);
        assertNotEquals(c1, c3);
    }
}
