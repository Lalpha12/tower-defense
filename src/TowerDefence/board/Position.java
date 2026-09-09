package TowerDefence.board;

/**
 * Représente une position sur un plateau à l'aide
 * d'une ligne et d'une colonne.
 */
public class Position {

    /** Numéro de ligne de la position */
    private int ligne;

    /** Numéro de colonne de la position */
    private int colonne;

    /**
     * Construit une position à partir de coordonnées.
     *
     * @param x numéro de la ligne
     * @param y numéro de la colonne
     */
    public Position(int x, int y) {
        this.colonne = y;
        this.ligne = x;
    }

    /**
     * Retourne le numéro de la ligne.
     *
     * @return la ligne de la position
     */
    public int getNbLigne() {
        return this.ligne;
    }

    /**
     * Retourne le numéro de la colonne.
     *
     * @return la colonne de la position
     */
    public int getNbColonne() {
        return this.colonne;
    }
    /*la methode equals */
    public boolean equals(Object o){
        if (!(o instanceof Position)){
            return false;
        }
        Position p = (Position) o;
        return ligne == p.ligne && colonne == p.colonne;   
    }

    /**
     * Retourne une représentation textuelle de la position.
     *
     * @return une chaîne de caractères sous la forme
     *         {@code Position(ligne,colonne)}
     */
    @Override
    public String toString() {
        return "Position(" + this.ligne + "," + this.colonne + ")";
    }
    
}

