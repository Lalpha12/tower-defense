package TowerDefence.Balloon;

import TowerDefence.board.Cell;
import TowerDefence.board.Position;
import java.util.ArrayList;

/**
 * Abstract class representing a balloon.
 *
 * A Balloon has:
 * - a speed (movement per tick),
 * - a resistance (number of damages it can absorb),
 * - a progress value inside the current cell,
 * - a frozen state,
 * - a path it follows,
 * - a position index inside that path.
 *
 * Note: awarding credits when a balloon is destroyed is the responsibility
 * of the game loop (Game.play()), not of the balloon itself.
 */
public abstract class Balloon {

    /** Current cell occupied by the balloon. */
    protected Cell cell;

    /** Speed of the balloon (distance progressed per tick). */
    protected float speed;

    /** Resistance of the balloon (health points). */
    protected int resistance;

    /** Progress inside the current cell (between 0 and 1). */
    protected float progress;

    /** Whether the balloon is frozen. */
    protected boolean frozen;

    /** Remaining ticks while the balloon is frozen. */
    protected int frozenTicks;

    /** Current index of the balloon on the path. */
    protected int currentPathIndex = 0;

    /** Unique identifier of the balloon. */
    protected String id;

    /** Time elapsed since the balloon started moving. */
    protected float time;

    /** Position index representing advancement along the path. */
    public int position = 0;

    /** The path followed by the balloon. */
    protected ArrayList<Position> path;

    /** Base speed saved before any slow/freeze effect. */
    protected float baseSpeed;

    /** Whether the balloon is currently slowed. */
    protected boolean slowed = false;

    /** Remaining ticks of the slow effect. */
    protected int slowedTick = 0;

    /** Speed reduction factor during slow effect. */
    protected float slowedFactor = 1.0f;

    /**
     * Constructs a Balloon with the given speed, resistance and identifier.
     *
     * @param speed      movement speed per tick
     * @param resistance initial health value
     * @param id         unique identifier
     */
    public Balloon(float speed, int resistance, String id) {
        this.speed = speed;
        this.resistance = resistance;
        this.progress = 0;
        this.frozen = false;
        this.frozenTicks = 0;
        this.id = id;
        this.time = 0;
        this.cell = null;
        this.path = null;
        this.baseSpeed = speed;
    }

    // -------------------------------------------------------------------------
    // Path
    // -------------------------------------------------------------------------
    /**
    * Assigns a path to the balloon
    * @param p the  news path 
    */
    public void putPath(ArrayList<Position> p) {
        this.path = p;
    }
    /**
    * Assigns a path to the balloon.
     * @return path the current path 
     */
    public ArrayList<Position> getPath() {
        return this.path;
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------
    /**
    * Returns the balloon identifier
     * @return id the current id
     */
    public String getId() { return this.id; }

   /**
    * Returns the current speed
    * @return speed  the current 
    */
    public float getSpeed() { return this.speed; }
     /**
      * Returns the resistance. 
      * @return resistance the current resistance 
      */
    public int getResistance() { return this.resistance; }

    /** Returns true if the balloon is currently frozen. 
    * @return frozen 
    */
    public boolean isFrozen() { return this.frozen; }

    /** Returns the elapsed time. 
     * @return time
    */
    public float getTime() { return this.time; }

    /** Returns the current cell. 
     * @return cell
    */
    public Cell getCell() { return this.cell; }

    /** Returns the current progress inside the cell. 
     * @return progress
    */
    public float getprogress() { return this.progress; }

    /**
     *  Returns the current position index on the path.
     * @return  position
     */
    public int getPosition() { return this.position; }

    /** 
     * Returns the current path index. 
     * @return currentPathIndex
     */
    public int getcurrentPathIndex() { return this.currentPathIndex; }

    /** 
     * Returns true if the balloon is currently slowed.
     * @return slowed
      */
    public boolean isSlowed() { return this.slowed; }

    // -------------------------------------------------------------------------
    // Movement
    // -------------------------------------------------------------------------

    /** 
     * Increases progress by the balloon's current speed.
       */
    public void AjoutProgress() {
        this.progress += this.speed;
    }

    /** 
     * Decreases progress by 1 (when crossing to the next cell). 
      */
    public void enleveProgress() {
        this.progress -= 1;
    }

    /** 
     * Increments the internal time counter by one tick. 
      */
    public void setTime() {
        this.time++;
    }

    /**
     *  Sets the current cell. 
     * @param c the  new  cell 
     */
    public void SetCell(Cell c) {
        this.cell = c;
    }

    /**
     *  Increments the position index by 1.
     */
    public void setPosition() {
        this.position += 1;
    }

    /**
     * Returns true if the balloon has reached the end of its path.
    
     * @return true if at or past the last path position
     */
    public Boolean isOut() {
        return this.position >= (this.path.size() - 1);
    }

    // -------------------------------------------------------------------------
    // Damage
    // -------------------------------------------------------------------------

    /**
     * Applies damage to the balloon.
     *
     * Resistance is decremented by {@code damage}.
     * It cannot go below 0.
     * Awarding credits to the player when resistance reaches 0 is handled
     * by {@code Game.play()}, not here.
     *
     * @param damage amount of damage to apply
     */
    public void takeDamage(int damage) {
        resistance -= damage;
        if (resistance < 0) {
            resistance = 0;
        }
        System.out.println(this.time + " : " + this.id
                + " touché (" + damage + " dmg)"
                + " — résistance restante : " + this.resistance);

        if (resistance == 0) {
            System.out.println(this.time + " : " + this.id + " détruit !");
        }
    }

    /**
     * Returns true if the balloon has been destroyed (resistance = 0).
     
     * @return true if destroyed
     */
    public boolean isDestroyed() {
        return resistance <= 0;
    }

    // -------------------------------------------------------------------------
    // Freeze
    // -------------------------------------------------------------------------

    /**
     * Freezes the balloon for a given number of ticks.
     * @param ticks number of ticks to stay frozen
     */
    public void freeze(int ticks) {
        frozen = true;
        frozenTicks = ticks;
        System.out.println(this.time + " : " + this.id
                + " gelé pendant " + ticks + " ticks");
    }

    /**
     * Updates the frozen state each tick.
     * Unfreezes the balloon when frozenTicks reaches 0.
     */
    public void updateFrozenState() {
        if (frozen) {
            frozenTicks--;
            if (frozenTicks <= 0) {
                frozen = false;
                System.out.println(this.time + " : " + this.id + " redémarre");
            }
        }
    }

    // -------------------------------------------------------------------------
    // Slow
    // -------------------------------------------------------------------------

    /**
     * Slows the balloon by a given factor for a given number of ticks.
     *
     * @param factor speed multiplier 
     * @param tick   duration of the effect in ticks
     */
    public void slow(float factor, int tick) {
        if (tick <= 0) return;
        if (factor <= 0) factor = 0.1f;
        this.slowed = true;
        this.slowedTick = tick;
        this.slowedFactor = factor;
        this.speed = baseSpeed * slowedFactor;
        System.out.println(this.time + " : " + this.id + " ralenti");
    }

    /**
     * Updates the slow state each tick.
     * Restores normal speed when slowedTick reaches 0.
     */
    public void updateSlowedState() {
        if (slowed) {
            slowedTick--;
            if (slowedTick <= 0) {
                slowed = false;
                slowedFactor = 1.0f;
                this.speed = baseSpeed;
                System.out.println(this.time + " : " + this.id
                        + " vitesse normale rétablie");
            }
        }
    }

    /**
     * Subtracts a fixed amount from the balloon's current speed.
     *
     * @param amount speed reduction
     */
    public void Subtractspeed(double amount) {
        this.speed -= amount;
        System.out.println(this.time + " : " + this.id + " ralenti");
    }

    // -------------------------------------------------------------------------
    // Display
    // -------------------------------------------------------------------------
    /**
     * to displaye
     * @return X
     */
    @Override
    public String toString() {
        return "X";
    }
}