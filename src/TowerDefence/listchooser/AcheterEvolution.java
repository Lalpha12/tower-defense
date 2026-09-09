package TowerDefence.listchooser;

import TowerDefence.Player;
import TowerDefence.board.Board;
import TowerDefence.tower.Evolution;
import TowerDefence.tower.Tour;
import java.util.ArrayList;
/**
 * action permettant au joueur  d'acheter une evolution 
 */
public class AcheterEvolution  implements Choice{
private final ListChooser c;
    /**
     * la methode permettant d'acheter une evolution parmis celles disponibles 
     * @param c le code listChooser permettant de choisir une evolution a acheter parmis tant dautre 
     */
    public AcheterEvolution(ListChooser c) {
        this.c = c;
    }


    @Override
    public void apply(Player p, Board b) {
        if (p.towers.isEmpty()) {
            System.out.println("Vous n'avez aucune tour à faire évoluer.");
            return;
        }
        Tour t = (Tour) c.choose(
            "Choisir une tour à faire évoluer", p.towers);

        ArrayList<Evolution> disponibles = new ArrayList<>();
        for (Evolution e : t.getEvolutions()) {
            if (!e.isbuy()) disponibles.add(e);
        }

        if (disponibles.isEmpty()) {
            System.out.println(t.getClass().getSimpleName()
                + " : aucune évolution disponible.");
            return;
        }

        Evolution e = (Evolution) c.choose(
            "Choisir une évolution", disponibles);

        p.acheterEvolution(t, e);
        
    }
     @Override
    public String toString(){
        return "Achater une Evolution";
    }
}
