package TowerDefence.tower;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import java.util.ArrayList;
/**
 * Dart Monkey tower.
 *
 * This is a basic damage-dealing tower.
 * It throws dart projectiles at balloons within its range.
 *
 * Initial characteristics:
 * - Projectile: "flechettes" (damage = 1)
 * - Range: 100
 * - Cadence: 1000 ms
 * - Cost: 200
 *
 * The tower targets the balloon that is the most advanced
 * along the path (highest position value).
 *
 * Available upgrades:
 * - Cadence upgrade
 * - Range upgrade
 * - Damage upgrade
 */
public class SingeFlechettes extends Tour{

    /**
     * Creates a Dart Monkey tower with predefined characteristics
     * and available evolutions.
     */
    public SingeFlechettes(){
        super(new Projectile("flechettes",1),100,1000,200);
        evolutions.add(new EvolutionCadence(0.25,150));   // +25% attack speed
        evolutions.add(new EvolutionPortee(0.25,100));    // +25% range
        evolutions.add(new EvolutionPuissance(1,250));    // +1 damage
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