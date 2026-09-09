package Tour;
import org.junit.jupiter.api.*;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import TowerDefence.tower.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
public class TourBombeTest {
    private Balloon b1;
    private Balloon b2;
    private Board board1;
    
    private Tour tour;
    


    @BeforeEach
    public void before(){
        this.b1=new BasicBalloon(2,2,"b1");
        this.b2= new BasicBalloon(3,1,"b2");
        this.board1= new BoardOne(10,10);
        this.tour=new TourBombe();
        

    }

    @Test
    public void TourBombe_attributs_correct(){
        assertEquals("TourBombe", tour.getprojectile().getName());
        assertEquals(2, tour.getprojectile().getDamage());
        assertEquals(150, tour.getPortee());
        assertEquals(1800, tour.getCadence());
        assertEquals(600, tour.getCout());
        assertEquals(4, tour.getEvolutions().size());
    }

    @Test 
    public void tirer_sur_un_ballon(){
        ArrayList<Balloon> l= new ArrayList<>();
        l.add(b1);
        
        board1.addBalloon(l);
        tour.setPosition(new Position(0, 0));
        board1.getCell(0,0).setvalueX(b1);
        int resistance = b1.getResistance();
        tour.tirer(board1);
        assertTrue(b1.getResistance() < resistance );
    }


    @Test
    public void tirer_sur_plusieurs_ballons(){
        ArrayList<Balloon> l1= new ArrayList<>();
        l1.add(b1);
        l1.add(b2);
        board1.addBalloon(l1);
        tour.setPosition(new Position(0, 0));
        board1.getCell(0,0).setvalueX(b1);
        board1.getCell(0,1).setvalueX(b2);
        int res1 = b1.getResistance();
        int res2= b2.getResistance();
        tour.tirer(board1);
        // verifie si tous  les ballons ont ete touches
        assertTrue(b1.getResistance()<res1);
        assertTrue(b2.getResistance()< res2);
    }


    

    
    
}
