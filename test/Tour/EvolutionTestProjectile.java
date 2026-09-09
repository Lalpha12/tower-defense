package Tour;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import TowerDefence.tower.*;

public class EvolutionTestProjectile {
    private Tour tour;
    private Tour tour1;
    private Evolution evo;

    @BeforeEach
    public void before(){
        this.tour=new SingeTireurElite();
        this.tour1= new SingeTireurElite();
        this.evo= new EvolutionProjectile(new Projectile("flechette tres pointue", 2),400);
    }
    @Test
    public void appliquer_projectile(){
        String res= tour.getprojectile().getName();
        String res1= tour1.getprojectile().getName();
        
        evo.appliquer(tour);
        
        assertEquals(res, tour.getprojectile().getName());
        
        assertEquals(res1, tour1.getprojectile().getName());
    }
    @Test
    public void retirer_projectile(){
        String res= tour.getprojectile().getName();
        String res1= tour1.getprojectile().getName();
        
        evo.appliquer(tour);
        evo.retirer(tour);
        
        assertEquals(res, tour.getprojectile().getName());
        
        assertEquals(res1, tour1.getprojectile().getName());
    }
}
