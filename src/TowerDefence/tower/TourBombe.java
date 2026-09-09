package TowerDefence.tower;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.*;
import java.util.ArrayList;

/**
 * Bomb tower.
 *
 * This tower shoots bombs that deal damage to balloons within its range.
 * The bomb projectile is intended to have an area effect (affecting multiple balloons).
 *
 * Initial characteristics (from the project specification):
 * - Cost: 600
 * - Range: 150
 * - Cadence: 1800 ms
 * - Projectile: Bombe (damage level 2)
 * Evolutions (from the project specification):
 * - Increase power (+1 damage)
 * - Increase range (+50%)
 * - Increase cadence (+25% faster shooting)
 * - Change projectile to "Extra bombe"
 */
public class TourBombe extends Tour{



    /**
     * Creates a new bomb tower with its default projectile and parameters.
     */
    public TourBombe() {
        super(new Projectile("TourBombe",2), 150, 1800, 600);
        evolutions.add(new EvolutionCadence(0.25,300));
        evolutions.add(new EvolutionPortee(0.5,250));
        evolutions.add(new EvolutionPuissance(1,200));
        evolutions.add(new EvolutionProjectile(new Projectile("ExtraBombe", 2), 400));
    }


     /**
     * Shoots using the current projectile.
     *
     * The tower looks for balloons in its neighborhood (within range) and
     * applies the projectile damage to each target.
     *
     * @param board the game board
     */
    public void tirer(Board board) {
        super.tirer(board);
        ArrayList<Balloon> cibles = neighborhood(board);

        if (!cibles.isEmpty()) {
            for (Balloon b : cibles) { 
                b.takeDamage(projectile.getDamage());  

            }
        }
    }


}
    

