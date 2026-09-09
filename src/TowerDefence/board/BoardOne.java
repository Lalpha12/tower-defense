package TowerDefence.board;

import TowerDefence.Balloon.Balloon;
import TowerDefence.paths.*;
import TowerDefence.tower.Tour;
import java.util.ArrayList;

/**
 * Concrete implementation of a Board.
 * <p>
 * BoardOne represents a simple game board with a single random path.
 * It extends the abstract Board class and provides a method to generate
 * a random path using the PathOne algorithm.
 * </p>
 */
public class BoardOne extends Board {
    ArrayList<Position> l;
    /**
     * Constructs a BoardOne with the specified number of rows and columns.
     * <p>
     * The board is initialized with empty cells, each having its Position.
     * </p>
     *
     * @param nbLigne  number of rows of the board
     * @param nbColonne number of columns of the board
     */
    public BoardOne(int nbLigne, int nbColonne) {
        super(nbLigne, nbColonne);
        this.l=this.path(this.board);
    }

    /**
     * Generates a random path on this board.
     * <p>
     * This method uses the PathOne class to create a random path starting
     * from a random entry row and ending at a different exit row. The path
     * is returned as a list of Positions representing the cells in the path.
     * </p>
     *@param cells  cells of the path
     * @return  path an ArrayList of Positions representing the generated path
     */
    public ArrayList<Position> path(Cell[][] cells) {
        PathOne p = new PathOne();
        return p.findPath(cells);
    }
   /** 
/**
 * Adds a balloon to the board.
 * 
 * Implementations should track the balloon on the board
 * (for example, by storing it in a list of balloons or updating the cell it occupies).
 *
 * @param b the Balloon to add
 */

public  void addBalloon(ArrayList<Balloon> b){
    this.listeBallon=b;
    for(Balloon balloon : this.listeBallon){
        balloon.putPath(this.l);
        balloon.SetCell(this.getCell(this.l.get(0).getNbLigne(),this.l.get(0).getNbColonne()));
    }
}

@Override
public boolean  putTower(Tour t,Position p){
    int x= p.getNbLigne();
    int y=p.getNbColonne();
    if (this.l.contains(new Position(x, y))){//pas de tours syur le chemin des ballons
        return false;
    }
    this.getCell(x, y).putTower(t);   
    t.setPosition(this.getCell(x, y).getPosition()); 
    return true;}


/**
 * Removes a balloon from the board.
 * 
 * Implementations should remove the balloon from the board
 * (for example, by removing it from a list of balloons or clearing the cell it occupies).
 *
 * @param b the Balloon to remove
 */

    /**
     * the function move the balloon in the current position to the next position 
     * @param b the currennt balloon for the move  
     */
    public void move( Balloon b) {
        super.move(b);
    
}

}


 