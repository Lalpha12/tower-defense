package Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TowerDefence.board.*;
import TowerDefence.tower.*;
import TowerDefence.Balloon.*;
import java.util.*;
public class TourRalentitBalloonTest {
    private Balloon balloon1;
    private Balloon balloon2;
    private Board boardOne;
    private Board boardTwo;
    private Tour tower1;
    private Tour tower2;
    @BeforeEach
    public  void before(){
     this.balloon1=new BasicBalloon(2,2,"basic");
     this.balloon2=new BasicBalloon(4, 6, "exceptionnel ballon");
     this.boardOne=new BoardOne(10, 12);
    this.boardTwo=new  BoardTwo(12, 12, 8);
    this.tower1=new TourRballoon(4);
    this.tower2=new TourRballoon(3);
    }

    @Test
     public void RalentitBalloonTest_boardone(){
        ArrayList <Balloon> list=new ArrayList<>();
        list.add(balloon1);
        list.add(balloon2);
        boardOne.addBalloon(list);
        tower1.setPosition(new Position(0,0));
        boardOne.getCell(0, 0).setvalueX(balloon1);
        assertFalse(balloon1.isSlowed());
        tower1.tirer(boardOne);
        assertTrue( balloon1.isSlowed());
        assertFalse(balloon2.isFrozen());
     }
      @Test
     public void RalentitBalloonTest_boardtwo(){
        ArrayList <Balloon> list=new ArrayList<>();
        list.add(balloon1);
        list.add(balloon2);
        boardTwo.addBalloon(list);
        tower2.setPosition(new Position(0,0));
        boardTwo.getCell(0, 0).setvalueX(balloon1);
        assertFalse(balloon1.isSlowed());
        tower2.tirer(boardTwo);
        assertTrue( balloon1.isSlowed());
        assertFalse(balloon2.isFrozen());
     }

}
