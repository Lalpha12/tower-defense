package TowerDefence;
import TowerDefence.board.*;
    /**
     * it's the class when call and organise to the 
     * livrable2a 
     * here the  create one ballon in one pathe  
     */
public class Livrable2aMain{
    /**
     * the constructor of the class 
     */
    public Livrable2aMain(){
    }
    /**
     *  we create the ballon and move the game
     * @param args string 
     */
    public static void main(String[] args) {

 // 1️ Vérification des arguments
    if (args.length != 3) {
        System.out.println(
            "Usage : java Livrable2a <largeur> <hauteur> <nbBallons>"
        );
        return;
    }

    // 2️ Lecture des arguments
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int nbBallons = Integer.parseInt(args[2]);
        // 3️ Création du plateau et du chemin
        BoardOne board = new BoardOne(height, width);
       Game game=new Game(board, nbBallons);
       game.play();
     

    
    }
}
