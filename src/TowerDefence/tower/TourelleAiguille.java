package TowerDefence.tower;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import java.util.ArrayList;

/**
 * Needle Turret tower.
 *
 * This is a medium-range damage-dealing tower.
 * It shoots needle projectiles at balloons within its range.
 *
 * Initial characteristics:
 * - Projectile: "aiguille" (damage = 1)
 * - Range: 80
 * - Cadence: 1200 ms
 * - Cost: 350
 *
 * The tower targets the most advanced balloon
 * (the one with the highest position value).
 *
 * Available upgrades:
 * - Cadence upgrade
 * - Range upgrade
 */
public class TourelleAiguille extends Tour{ 
    
    /**
     * Creates a Needle Turret tower with predefined characteristics
     * and available evolutions.
     */
    public TourelleAiguille(){
        super(new Projectile("aiguille",1),80,1200,350);

        // Add available evolutions (upgrades)
        evolutions.add(new EvolutionCadence(0.25,200));  // +25% attack speed
        evolutions.add(new EvolutionPortee(0.20,150));   // +20% range
    }

    /**
     * Makes the tower attack.
     *
     * The method:
     * 1) collects balloons within range,
     * 2) ignores invalid balloons (null, destroyed, or out),
     * 3) selects the most advanced balloon (highest position),
     * 4) applies damage using the projectile,
     * 5) prints a message if the balloon is destroyed.
     *
     * @param b the game board
     */
    public void tirer(Board b){
       super.tirer(b);
        /**Balloon b_proche=this.cibler(b);
        if (b_proche != null){
            b_proche.takeDamage(this.projectile.getDamage());
        }*/
       super.generate(b);
        
    }
   
   
}