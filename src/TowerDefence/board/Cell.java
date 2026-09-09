package TowerDefence.board;

import TowerDefence.Balloon.Balloon;
import TowerDefence.tower.Tour;

/**
 * Represents a single cell on the game board.
 * 
 * A cell is identified by its (x, y) coordinates.
 * It can be used as a basic element for paths, towers,
 * or balloon positions on the plateau.
 */
public class Cell{
    /** 
    * Position of the cell on the board 
    * */
    private Position position;


    /** 
     * Display value of the cell (default is ".") 
     * */
    private Balloon value;
    /**
     * la tour
     */
    private Tour tower;

    /**
     * Constructs a Cell with the given position.
     * Initializes the value to "." (empty cell).
     * 
     * @param p the Position of the cell
     */
    public Cell(Position p) {
        this.position = p;
        this.value = null;
    }

     /**
     * Returns the position of this cell.
     * 
     * @return the Position object representing (x, y)
     */
    public Position getPosition() {
        return this.position;
    }

    
    /**
     * Sets the display value of the cell.
     * 
     * Example: "x" for path, "." for empty, or other markers.
     * 
     * @param val the new display value of the cell
     */
    public void setvalueX(Balloon val) {
        this.value = val;
    }
    /*la methode equals */
    public boolean equals(Object other){
        if (!(other instanceof Cell)){
            return false;
        }
        Cell c = (Cell) other;
        return position.equals(c.getPosition());
    }

    /**
     * Returns the string representation of the cell.
     * 
     * Currently, it returns the value of the cell.
     * 
     * @return the display value of the cell
     */
    @Override
    public String toString() {
        if(this.value==null){
            if(this.tower==null){
                return ".";
            }
            else{
                return this.tower.toString();
            }
        }
        else{return this.value.toString();}
    }
    /**
     * the currenct Balloon
     * @return value
     */
    public Balloon getValue() {
        return this.value;
    }
    /**
     * place la tour dans cette cellule
     * @param t la tour à placer dans la cellule 
     */
    public void putTower(Tour t) {
        this.tower=t;
        
    }
}