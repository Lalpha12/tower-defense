package TowerDefence.board;
import TowerDefence.Balloon.*;
import TowerDefence.tower.Tour;
import java.util.ArrayList;

/**
 * the board of the game
 */
public abstract  class Board {

    /** the number of rows of the board */
    private int nbLigne;

    /** the number of columns of the board */
    private int nbColonne;

    /**the list of ballon */

    public  ArrayList<Balloon> listeBallon;
    /** The array of cells composing the board. */
    protected Cell[][] board;


    /**
     * the board class
     * @param nbLigne the number of rows of the board
     * @param nbColonne the number of columns of the board
     */
    public Board(int nbLigne,int nbColonne){
        this.nbLigne = nbLigne;
        this.nbColonne = nbColonne;
        this.board=new Cell [nbLigne][nbColonne];

        /* I fill the array with empty cells */
        for (int i=0 ; i<nbLigne ; i++){
            for (int j=0 ; j<nbColonne ; j++){
                 this.board[i][j] = new Cell(new Position(i, j));
            }
        }
    }
/**
 * placee une tour sur le plateau a une position donnée 
 * @param t la tour a placer 
 * @param p la position ou placer la tour 
 * @return true si la tour a été placer correctement 
 */
public abstract boolean  putTower(Tour t, Position p);

    

    /**
     * get the number of rows of this board 
     * @return the number of rows of this board
     */
    public int getNbLigne(){
        return this.nbLigne;
    }

    /**
     * get the number of columns of this board
     * @return the number of columns of this board
     */ 
    public int getNbColonne(){
        return this.nbColonne;
    }

    /**
     * get a cell of the board
     * @param i the row index
     * @param j the column index
     * @return the cell corresponding to this position
     */
    public Cell getCell(int i,int j){
        return this.board[i][j];
    }
    /**
     * Prints the board to the console using each cell's toString method.
     * Each row is printed on a separate line.
     */
    public void affiche() {
        for (int i = 0; i < this.nbLigne; i++) {
            for (int j = 0; j < this.nbColonne; j++) {
                System.out.print(this.board[i][j] + " "); // Cell.toString()
            }
            System.out.println();
        }
        System.err.println("\n");
    }


    /**
     * the toString method for the board *
     * @return res it the point for display
    */
    public String tostring(){
        String res = "";
        for (int i = 0 ; i<this.nbLigne ; i++){
            for (int j = 0 ;j<this.nbColonne;j++){
                res += "+---";
            }
            res += "+\n";
            for (int j = 0 ; j<this.nbColonne ; j++){
                res += "|   ";
            }
            res += "|\n";
        }
        for (int j = 0 ;j<this.nbColonne ; j++){
            res += "+---";
        }
        res += "+\n";
        return res;
    }
    /**
     *this function move the balloon and also 
     * @param b the balloon for move in the board 
     */
    public void move(Balloon b) {
    b.setTime();
        // Si le ballon est gelé
        if (b.isFrozen()) {
            b.updateFrozenState();
            
            return;
        }
        b.AjoutProgress();

        while (b.getprogress() >= 1 && b.getPosition() <  b.getPath().size()) {
            Position current =  b.getPath().get(b.getPosition());
            Cell currentCell = this.getCell(
                current.getNbLigne(),
                current.getNbColonne()
            );

            // Quitte l’ancienne cellule
            if (b.getCell() != null) {
                
                b.getCell().setvalueX(null);
            }
            // Entre dans la nouvelle cellule
            currentCell.setvalueX(b);
            b.SetCell(currentCell);
            b.enleveProgress();
            b.setPosition();//incremente la position de 1
        }
       
    // On stocke le temps dans le ballon
    b.setTime();

    
}
/**
 *  it's the getteur we return the listBalloon
 * @return listeBallon 
 */
public ArrayList <Balloon> getBalloons(){
    return this.listeBallon;
}

/**
     * Adds a balloon to the board.
     * <p>
     * This is an abstract method and must be implemented by subclasses
     * to define how a Balloon is added to the board.
     * </p>
     *
     * @param b the Balloon to add
     */
    public abstract void addBalloon(ArrayList<Balloon> b);



    /**
     * Removes a balloon from the board.
     * <p>
     * This is an abstract method and must be implemented by subclasses
     * to define how a Balloon is removed from the board.
     * </p>
     *
     * @param b the Balloon to remove
     */
   public void removeBalloon(Balloon b){
    if (b.getCell() != null) {
        b.getCell().setvalueX(null);
    }
    if (this.listeBallon != null) {
        this.listeBallon.remove(b);
    }
}
/**
 * renvoie toute les positions 
 * @return toutes les positions du plateau 
 */
public ArrayList<Position>getAllPositions(){
    ArrayList<Position> res=new ArrayList<>();
    for(int i=0 ;i<this.getNbLigne();i++){
        for(int j=0;j<this.getNbColonne();j++){
            res.add(new Position(i,j));
        }
    }return res;
}



   /* public void afficheWithBalloons(ArrayList<BalloonRfor> balloons, ArrayList<ArrayList<Position>> paths) {
    String[][] display = new String[nbLigne][nbColonne];
    
    for (int i = 0; i < nbLigne; i++) {
        for (int j = 0; j < nbColonne; j++) {
            display[i][j] = board[i][j].toString();
        }
    }   
        // on ajoute les ballon 
    for (int i = 0; i < balloons.size(); i++) {
        BalloonRfor b = balloons.get(i);
        ArrayList<Position> path = paths.get(i);
        int index = b.getcurrentPathIndex();
        if (index < path.size()) {
            Position p = path.get(index);
            display[p.getNbLigne()][p.getNbColonne()] = "B"; // B for the  balloon
        }
    }
    for (int i = 0; i < nbLigne; i++) {
        for (int j = 0; j < nbColonne; j++) {
            System.out.print(display[i][j] + " ");
        }
        System.out.println();
    }
} */
/**
 * renvoie le plateau de jeu 
 * @return le plateau de cellule 
 */
public Cell[][] getBoard(){
   return this.board;
}
                                                   

}