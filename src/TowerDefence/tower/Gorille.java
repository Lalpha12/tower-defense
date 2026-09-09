package TowerDefence.tower;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Gorille tower
 * this tower randomly attacks one balloon withings its range
 */ 
public class Gorille extends Tour {

    /**
     * constructor for gorille tower
     * create a tower with:
     * a projectile named gorille dealing 2 damage 
     * a range of 200 
     * a firing rate of 300
     * a cost of 1200
     */

    public Gorille() {
        super(new Projectile("Gorille",2), 200, 300, 1200);
        evolutions.add(new EvolutionCadence(0.2,1000));
        evolutions.add(new EvolutionPortee(0.5,400));
        evolutions.add(new EvolutionPuissance(2,600));
        
    }

    

    /**
     * shoots at a random balloon within the tower's range
     * if the targeted balloon is destroyed after taking damage,
     * it is removed from the board 
     */
    public void tirer(Board board) {
        super.tirer(board);
        ArrayList<Balloon> cibles = neighborhood(board);
        
        if (!cibles.isEmpty()) {
            Random rand = new Random();
            Balloon cible = cibles.get(rand.nextInt(cibles.size())); 
            cible.takeDamage(projectile.getDamage());
        
            if(cible.isDestroyed()){
                board.removeBalloon(cible);
            }
            
            
            
        }
    }

    
    

    
}
