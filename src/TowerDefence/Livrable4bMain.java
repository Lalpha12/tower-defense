package TowerDefence;

import TowerDefence.board.BoardTwo;
import TowerDefence.tower.Tour;
/**
 * classe principale pour lancer le livrable4b
 */
public class Livrable4bMain {
    /**
     * le constructeur par defaut du livrable
     */
    public Livrable4bMain(){
        
    }
    /**
     *  le main du livrable4b
     * @param args les arguments de la ligne de commande 
     */
    public static void main(String[] args) {
        if (args.length!=3) {
        System.out.println(  "Veuillez entrer trois nombres :hauteur , largeur et nombre de chemins");
        return;
        }
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int nbChemins =(Integer.parseInt(args[2]));

        BoardTwo board= new BoardTwo(height, width, nbChemins);
        Game1 game= new Game1(board, nbChemins);
        game.display_manche(10);
        
    }
    
}
