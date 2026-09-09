package TowerDefence.board;

import java.util.ArrayList;
import java.util.List;

import TowerDefence.Balloon.Balloon;
import TowerDefence.paths.*;
import TowerDefence.tower.Tour;

/**
 * Concrete implementation of a Board with multiple straight paths.
 * 
 * BoardTwo generates a board with a specified number of straight paths
 * (horizontal or vertical) using the PathTwo algorithm.
 * Each path is stored as a list of Positions and the cells in the path
 * are marked with "x".
 */
public class BoardTwo extends Board {

    /** Number of paths to generate on the board */
    private int nPaths;
    private ArrayList<ArrayList<Position>> l;
    /**
     * Constructs a BoardTwo with the given dimensions and number of paths.
     * 
     * @param l number of rows of the board
     * @param c number of columns of the board
     * @param n number of straight paths to generate
     */
    public BoardTwo(int l, int c, int n) {
        super(l, c);
        this.nPaths = n;
        this.l=this.path(board);
    }
    /**
     * renvoie la liste des chemins que les ballons peuvent suivrent  
     * @return la liste des chemins des positions du tableau
     */
    public ArrayList<ArrayList<Position>> getPath(){
        return this.l;
    }
    /**
     * place une tour comme indiqué
     * @param t la tour à placer 
     * @param position la position du plateau 
     * @return true si la tour a été bien placé
     */
    @Override
    public boolean  putTower(Tour t,Position position){
        int x=position.getNbLigne();
        int y =position.getNbColonne();
    for (ArrayList<Position>p:this.l )   { 
    if (p.contains(new Position(x, y))){//pas de tours syur le chemin des ballons
        return false;
    }
}
    this.getCell(x, y).putTower(t);  
      t.setPosition(this.getCell(x, y).getPosition());   
    return true;}

    /**
     * Generates multiple straight paths on the board.
     * 
     * For each path, a new straight path is generated using PathTwo
     * and added to the list of paths. Cells that belong to the paths
     * are marked with "x".
     * @param cells cells 
     * @return  chemin .an ArrayList of ArrayLists of Positions, where each inner
     *         list represents a single path
     */
    public ArrayList<ArrayList<Position>> path(Cell[][] cells) {

        ArrayList<ArrayList<Position>> chemins = new ArrayList<>();
        PathTwo p = new PathTwo();

        for (int i = 0; i < this.nPaths; i++) {
            ArrayList<Position> chemin = p.findPath(cells);
            while(chemins.contains(chemin)){
                chemin = p.findPath(cells);}
            {chemins.add(chemin);} 
        }

        return chemins;
    }

       
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
    int i=0;
    for(Balloon balloon : this.listeBallon){
        balloon.putPath(this.l.get(i));
        balloon.SetCell(this.getCell(this.l.get(i).get(0).getNbLigne(),this.l.get(i).get(0).getNbColonne()));
        i++;
        if(i>=this.l.size()){
            i=0;
        }
    }
}


    /**
     * the function move the balloon in the current position to the next position 
     * @param b the currennt balloon for the move  
     */
    public void move( Balloon b) {
        super.move(b);
    }


}


