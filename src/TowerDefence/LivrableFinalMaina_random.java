package TowerDefence;

import TowerDefence.board.BoardOne;
import TowerDefence.board.BoardTwo;
import TowerDefence.listchooser.InteractiveListChooser;
import TowerDefence.listchooser.ListChooser;
import TowerDefence.listchooser.RandomListChooser;
/**
 * le livrable final  du jeu de maniere aleatoire 
 */
public class LivrableFinalMaina_random {

    /**
     * le constructeur par defaut de la classe
     */
    public LivrableFinalMaina_random() {
    }

    /**
     * le main pour le livrable 
     * @param args les arguments en ligne de commande :
     *             hauteur largeur nbBallons typePlateau typeJoueur
     */
    public static void main(String[] args) {

       if (args.length!=3) {
        System.out.println(  "Veuillez entrer trois nombres :ligne , colonne et nombre de balloon");
        return;
        }
        int ligne = Integer.parseInt(args[0]);
        int colone = Integer.parseInt(args[1]);
        //int nbChemins =(Integer.parseInt(args[2]));
        int nbBallons=Integer.parseInt(args[2]);
        String typeJoueur = "aleatoire";


        System.out.println("=== Informations ===");
        System.out.println("  typeJoueur : " + typeJoueur);
        System.out.println("  Plateau    : " + ligne + " x " + colone);
        System.out.println("  Ballons/m  : " + nbBallons);
        System.out.println("  Plateau    : " + "a");
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
        BoardOne b=new BoardOne(ligne, colone);
        FinalGame game=new FinalGame(b, nbBallons, c);
        game.play();


    }
}
