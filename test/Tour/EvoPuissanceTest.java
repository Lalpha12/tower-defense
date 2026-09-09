package Tour;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import TowerDefence.tower.*;

public class EvoPuissanceTest {
    private Tour tour;
    private Tour tour1;
    private Evolution evo;

    @BeforeEach
    public void before(){
        this.tour=new SingeFlechettes();
        this.tour1= new SingeFlechettes();
        this.evo= new EvolutionPuissance(1,250);
    }

    
    @Test
    public void appliquer_puissance(){
        int res= tour.getprojectile().getDamage();
        int res1= tour1.getprojectile().getDamage();
        evo.appliquer(tour);
        
        assertEquals(res+1, tour.getprojectile().getDamage());
        
        assertEquals(res1, tour1.getprojectile().getDamage());
    }

    @Test
    public void retirer_Puissance(){
        int res= tour.getprojectile().getDamage();
        int res1= tour1.getprojectile().getDamage();
        evo.appliquer(tour);
        evo.retirer(tour);
        assertEquals(res, tour.getprojectile().getDamage());
        assertEquals(res1, tour1.getprojectile().getDamage());

    }

    
}
