package TowerDefence;

import TowerDefence.board.BoardOne;
import TowerDefence.board.BoardTwo;
import TowerDefence.listchooser.InteractiveListChooser;
import TowerDefence.listchooser.ListChooser;
import TowerDefence.listchooser.RandomListChooser;
import java.util.Random;
/**
 * la classe du livrable 5 du jeu 
 */
public class Livrable5Main {

    /**
     * le constructeur par defaut de la classe
     */
    public Livrable5Main() {
    }

    /**
     * le main pour le livrable 5
     * @param args les arguments en ligne de commande :
     *             hauteur largeur nbBallons typePlateau typeJoueur
     */
    public static void main(String[] args) {

      
         if (args.length != 5) {
        System.out.println("Usage : java Livrable5Main <hauteur> <largeur> <nbBallons> <typePlateau> <typeJoueur>");
        return;
     }
        int hauteur      = Integer.parseInt(args[0]);
        int largeur      = Integer.parseInt(args[1]);
        int nbBallons    = Integer.parseInt(args[2]);
        String typeboard = args[3];
        String typeJoueur = args[4];

        System.out.println("=== Informations ===");
        System.out.println("  typeJoueur : " + typeJoueur);
        System.out.println("  Plateau    : " + hauteur + " x " + largeur);
        System.out.println("  Ballons/m  : " + nbBallons);
        System.out.println("  Plateau    : " + typeboard);
        System.out.println("=====================");

        ListChooser c;
        if (typeJoueur.equalsIgnoreCase("aleatoire")) {
            c = new RandomListChooser<>();
        } else {
            if (!typeJoueur.equalsIgnoreCase("humain")) {
                System.out.println("typeJoueur inconnu \"" + typeJoueur
                        + "\" — typeJoueur interactif utilisé par défaut.");
            }
            c = new InteractiveListChooser<>();
        }

        if (typeboard.equalsIgnoreCase("chemin")) {
            BoardOne board = new BoardOne(hauteur, largeur);
            FinalGame game = new FinalGame(board, nbBallons, c);
            game.play();
        } else if (typeboard.equalsIgnoreCase("libre")) {
            Random rand = new Random();
            int max = hauteur + largeur;
            int nbpath = rand.nextInt(max) + 1;
            BoardTwo board = new BoardTwo(hauteur, largeur, nbpath);
            FinalGame game = new FinalGame(board, nbBallons, c);
            game.play();
        } else {
            System.out.println("typePlateau inconnu \"" + typeboard
                    + "\" — valeurs acceptées : chemin, libre");
        }
    }
}
