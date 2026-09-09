package TowerDefence;

import TowerDefence.board.BoardOne;
import TowerDefence.board.BoardTwo;
import TowerDefence.listchooser.InteractiveListChooser;
import TowerDefence.listchooser.ListChooser;
import TowerDefence.listchooser.RandomListChooser;
/**
 * le livrable final du jeu de maniere interactive pour le board two  
 */
public class LivrableFinalMainb_iter {

    /**
     * le constructeur par defaut de la classe
     */
    public LivrableFinalMainb_iter() {
    }

    /**
     * le main pour le livrable 
     * @param args les arguments en ligne de commande :
     *             hauteur largeur nbBallons typePlateau typeJoueur
     */
    public static void main(String[] args) {

       if (args.length!=3) {
        System.out.println(  "Veuillez entrer trois nombres :hauteur , largeur et nombre de chemin");
        return;
        }
        int hauteur = Integer.parseInt(args[0]);
        int largeur = Integer.parseInt(args[1]);
        //int nbChemins =(Integer.parseInt(args[2]));
        int nbpaths=Integer.parseInt(args[2]);
        String typeJoueur = "humain";


        System.out.println("=== Informations ===");
        System.out.println("  typeJoueur : " + typeJoueur);
        System.out.println("  Plateau    : " + hauteur + " x " + largeur);
        System.out.println("  nbchemin  : " + nbpaths);
        System.out.println("  Plateau    : " + "b");
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
        BoardTwo b=new BoardTwo(hauteur,largeur,nbpaths);
        FinalGame game=new FinalGame(b, nbpaths, c);
        game.play();


    }
}
