package TowerDefence.tower;
import TowerDefence.Balloon.Balloon;
import TowerDefence.board.*;
import java.util.ArrayList;



/**
 * TourRballoon tower
 * this tower does not deal direct damage 
 * instead,it slow down the balloon that is closest to the en of the  
 */
public class TourRballoon extends Tour{
    /**
     * the effect applied to the balloon
     */
    protected int  effect;

    /**
     * constructor
     * @param effect  effect the slowing effect applied to the target balloon
     */
    public TourRballoon(int  effect){
        super(null, 100, 1500, 400);
        this.effect=effect;
    }


    /**
     * Shoots (applies effect) to the balloon closest to the end of the path
     * within the tower's range.
     * @param b the board 
     */
 public void tirer(Board b){
      Balloon target=this.cibler(b);
        if (target!=null) {
            target.slow(0.5f, effect);
        }
    }

    /**
     * Increases tower range.
     */
    public void augmenterPortee(){
        this.portee+=100;
    };

    /**
     * Increases attack cooldown (slower firing).
     */
    public  void augmenterCadence(){
        this.cadence+=1500;
    }

    /**
     * No power upgrade (support tower).
     */
    public  void augmenterPuissance(){
        // No projectile → no damage upgrade
    };
    
     
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