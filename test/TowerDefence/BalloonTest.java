package TowerDefence;

import TowerDefence.Balloon.BasicBalloon;
import TowerDefence.board.*;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;



public class BalloonTest {

   private BasicBalloon b1;
   private BasicBalloon b2;
   @BeforeEach
   public void before(){
    this.b1=new BasicBalloon(2f, 3,"xe");
    this.b2= new BasicBalloon(3f, 0, "mo");
   }


 @Test
    void testGettersAndDefaults() {
        assertEquals("xe", b1.getId());
        assertEquals(2f, b1.getSpeed(), 1e-6);
        assertFalse(b1.isFrozen());
        assertEquals(0f, b1.getprogress(), 1e-6);
        assertEquals(0f, b1.getTime(), 1e-6);
        assertEquals(0, b1.getPosition());
        assertEquals("X", b1.toString());
    }

    @Test
    void testDestroyed() {
        assertTrue(b2.isDestroyed());     
        assertFalse(b1.isDestroyed());     
        b1.takeDamage(3);
        assertTrue(b1.isDestroyed());
    }
        @Test
    void testFreezeAndUnfreeze() {
        b1.freeze(2);
        assertTrue(b1.isFrozen());

        b1.updateFrozenState(); 
        assertTrue(b1.isFrozen());

        b1.updateFrozenState(); 
        assertFalse(b1.isFrozen());
    }
  @Test
    void testProgressAndTime() {
        b1.AjoutProgress(); // + speed (2)
        assertEquals(2f, b1.getprogress(), 1e-6);

        b1.enleveProgress(); // -1
        assertEquals(1f, b1.getprogress(), 1e-6);

        b1.setTime();
        b1.setTime();
        assertEquals(2f, b1.getTime(), 1e-6);
    }
     @Test
    void testPathAndIsOut() {
        ArrayList<Position> path = new ArrayList<>();
        path.add(new Position(0, 0));
        path.add(new Position(0, 1));
        path.add(new Position(0, 2));

        b1.putPath(path);
        assertSame(path, b1.getPath());

        assertFalse(b1.isOut()); // position=0

        b1.setPosition(); // 1
        assertFalse(b1.isOut());

        b1.setPosition(); // 2 (>= size-1)
        assertTrue(b1.isOut());
    }
}