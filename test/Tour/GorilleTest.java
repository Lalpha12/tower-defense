package Tour;
import org.junit.jupiter.api.*;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import TowerDefence.tower.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class GorilleTest {

    private Balloon b1;
    private Balloon b2;
    private Board board1;
    private Board board2;
    private Tour tour1;
    private Tour tour2;


    @BeforeEach
    public void before(){
        this.b1=new BasicBalloon(2,2,"b1");
        this.b2= new BasicBalloon(3,1,"b2");
        this.board1= new BoardOne(10,10);
        this.board2= new BoardTwo(10,10,3);
        this.tour1=new Gorille();
        this.tour2= new Gorille();

    }

    @Test
    public void gorille_attributs_correct(){
        assertEquals("Gorille", tour1.getprojectile().getName());
        assertEquals(2, tour1.getprojectile().getDamage());
        assertEquals(200, tour1.getPortee());
        assertEquals(300, tour1.getCadence());
        assertEquals(1200, tour1.getCout());
        assertEquals(3, tour1.getEvolutions().size());
    }
    @Test
    public void tirer_applique_degats_board1(){
        ArrayList<Balloon> l= new ArrayList<>();
        l.add(b1);
        
        board1.addBalloon(l);
        tour1.setPosition(new Position(0, 0));
        board1.getCell(0,0).setvalueX(b1);
        int resistance = b1.getResistance();
        tour1.tirer(board1);

        assertTrue(b1.getResistance() < resistance );
    }
    @Test
    public void tirer_applique_degats_board2(){
        ArrayList<Balloon> l1= new ArrayList<>();
        l1.add(b2);
        
        board2.addBalloon(l1);
        tour2.setPosition(new Position(1, 1));
        board2.getCell(1,1).setvalueX(b2);
        
        tour2.tirer(board2);
        // verifie si la resistance du ballon a diminiuer 
        assertTrue(b2.getResistance() < 1 );
    }

    @Test
    public void tirer_ballon_detruit(){
        ArrayList<Balloon> l1= new ArrayList<>();
        l1.add(b2);
       
        board1.addBalloon(l1);
        tour2.setPosition(new Position(1, 1));
        board1.getCell(1,2).setvalueX(b2);
        tour2.tirer(board1);
        // verifie si le ballon b2 de resistance 1 a ete supprimer de ma liste de ballon puisqu'il a ete touche

        assertTrue(b2.isDestroyed() || !board1.getBalloons().contains(b2));      

    }

    @Test 
    public void tirer_plusieurs_ballons(){
        ArrayList<Balloon> l1= new ArrayList<>();
        l1.add(b1);
        l1.add(b2);
        board1.addBalloon(l1);
        tour2.setPosition(new Position(1, 1));
        board1.getCell(1,1).setvalueX(b1);
        board1.getCell(1,2).setvalueX(b2);
        int res1 = b1.getResistance();
        int res2= b2.getResistance();
        tour2.tirer(board1);
        // verifie si au moins un ballon a ete touche
        assertTrue(b1.getResistance()<res1 || b2.getResistance()< res2);
        
    }

   
    
}
