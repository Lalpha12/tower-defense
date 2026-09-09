package TowerDefence.tower;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import java.util.ArrayList;

/**
 * Freeze tower.
 *
 * This tower does not deal damage. Instead, it freezes a balloon
 * for a certain number of ticks.
 *
 * Initial characteristics (from the project specification):
 * - Cost: 400
 * - Range: 100
 * - Cadence: 1500 ms
 * - No projectile (special effect tower)
 *
 * The tower targets the balloon that is closest to the end of its path.
 * If two balloons are equally close, it selects the one that is more
 * advanced inside its current cell (greater progress value).
 */
public class TourfrozenBalloon extends Tour {

    /** Duration of the freezing effect (in ticks). */
    protected int effect;

    /**
     * Creates a freeze tower with a specified freeze duration.
     *
     * @param effect number of ticks during which the balloon will be frozen
     */
    public TourfrozenBalloon(int effect) {
        super(null, 100, 1500, 400);
        this.effect = effect;
    }

    /**
     * Applies the freeze effect to the most advanced balloon in range.
     *
     * The method:
     * 1) collects balloons in range,
     * 2) selects the balloon closest to the end of its path,
     * 3) freezes that balloon for {@code effect} ticks.
     *
     * @param b the game board
     */
    public void tirer(Board b) {
        
    Balloon target=this.cibler(b);
        if (target != null) {
            target.freeze(effect);
        }
    }
   

    /**
    *  getteur of effect
     * @return current slowing effect value
     */
    public double geteffect(){
        return this.effect;
    }
    /**
     * Sets a new slowing effect value.
     * @param temp new effect value
     */
    public void seteffect(int temp){
        this.effect=temp;

    }

}



