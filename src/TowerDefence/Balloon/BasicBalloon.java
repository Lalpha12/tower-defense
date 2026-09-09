package TowerDefence.Balloon;

/**
 * Basic implementation of a Balloon.
 * Used for testing movement and game mechanics.
 */
public class BasicBalloon extends Balloon {
   /**
    * this constructeur reprsente the balloon basic if we need to fixe the resistence,
    * special for this class or speed special
    * @param speed speed of the ballon can to the ballon to move 
    * @param resistance resistane
    * @param id the id for see the trace of ballon 
    */
    public BasicBalloon(float speed, int resistance, String id) {
        super(speed, resistance,id);
    }
}
