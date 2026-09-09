package Tour;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import TowerDefence.tower.*;
public class EvolutionTestPortee{
    private Tour tour;
    private Tour tour1;
    private Evolution evo;

    @BeforeEach
    public void before(){
        this.tour=new TourBombe();
        this.tour1= new TourBombe();
        this.evo= new EvolutionPortee(1.2,150);
    }
    @Test
    public void appliquer_portee(){
        int res= tour.getPortee();
        int res1= tour1.getPortee();
        evo.appliquer(tour);
        //verifie que la portee est reduite
        assertEquals((int)(res*1.2), tour.getPortee());
        // verfie que tour1 reste inchanger car pas d'evo appliquer
        assertEquals(res1, tour1.getPortee());
    }
    @Test
    public void retirer_portee(){
        int res= tour.getPortee();
        int res1= tour1.getPortee();
        evo.appliquer(tour);
        evo.retirer(tour);
        //verifie que la portee revient a sa valeur iniitiale
        assertEquals(res, tour.getPortee());
        // verfie que tour1 reste inchanger car pas d'evo appliquer
        assertEquals(res1, tour1.getPortee());
    }
}