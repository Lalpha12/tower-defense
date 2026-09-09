package Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TowerDefence.board.*;
import TowerDefence.tower.*;
import TowerDefence.Balloon.*;
import java.util.*;

public class TourfrozenTest {

    private Balloon b1;
    private Balloon b2;
    private  Board board1;
    private  Board board2;
    private Tour T1;
    private Tour T2;


    @BeforeEach
    public void  before(){
        this.b1=new BasicBalloon(2, 1, "basic1");
        this.b2=new BasicBalloon(3, 4, "basic2");
        this.board1=new BoardOne(10, 12);
        this.board2=new BoardTwo(12, 12, 5);
        this.T1=new TourfrozenBalloon(3);
        this.T2=new TourfrozenBalloon(2);
    }
    

   @Test
    public void  frozenBalloontest_board(){
     
        ArrayList<Balloon> list=new  ArrayList<>();
        list.add(b1);
        list.add(b2);
        board1.addBalloon(list);
        T1.setPosition(new Position(0, 0) );
    
        board1.getCell(0, 0).setvalueX(b1);
        assertFalse(b1.isFrozen());
        T1.tirer(board1);
        //le ballon doit etre ggele 
        assertTrue(b1.isFrozen());


    }
    @Test
    public void frozenBalloontest_boardTwo(){
        ArrayList<Balloon> list2=new ArrayList<>();
        list2.add(b1);
        list2.add(b2);
        board2.addBalloon(list2);
        T2.setPosition(new Position(0, 0));
        board2.getCell(0, 0).setvalueX(b1);
        
        assertFalse(b1.isFrozen());
        T2.tirer(board2);
        //le ballon doit etre gele 
        assertTrue(b1.isFrozen());

        
    }
 

    
}
