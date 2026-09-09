package TowerDefence;

import TowerDefence.board.BoardOne;
import TowerDefence.tower.Tour;
/**
 * la classe principale pour le livrable4a
 */
public class Livrable4aMain {
    /**
     * le constructeur par defaut de la classe 
     */
    public Livrable4aMain(){

    }
/**
 * le main pour le livrable 4a
 * @param args les arguments en ligne de commande 
 */
 public static void main(String[] args) {
    if (args.length!=3) {
        System.out.println(  "Usage : java Livrable4a <height> <width> <number_of_ballons>");
        return;
        
    }

    int width=Integer.parseInt(args[0]);
    int height=Integer.parseInt(args[1]);
    int nbBallons=Integer.parseInt(args[2]);

    BoardOne board=new BoardOne(height, width);
    Game1 game=new Game1(board, nbBallons);
    game.display_manche(10);
 }
}