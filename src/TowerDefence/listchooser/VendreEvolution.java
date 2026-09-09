package TowerDefence.listchooser;

import java.util.ArrayList;

import TowerDefence.Player;
import TowerDefence.board.Board;
import TowerDefence.tower.*;
/**
 * action permettant au joueur de vendre une evolution 
 */
public class VendreEvolution implements Choice  {
    private final ListChooser c;
    /**
     * realise une action qui permette au joueur de vendre une evolution 
     * @param c le code listChooser utilisé pour permettre au joueur de choisir une evolution  a vendre parmis celles disponibles 
     */
    public VendreEvolution(ListChooser c) {
        this.c = c;
    }

    @Override
    public void apply(Player p, Board b) {
        if (p.towers.isEmpty()) {
            System.out.println("Vous n'avez aucune tour.");
            return;
        }
        Tour t = (Tour) c.choose(
            "Choisir une tour dont vendre une évolution", p.towers);

        ArrayList<Evolution> achetees = new ArrayList<>();
        for (Evolution e : t.getEvolutions()) {
            if (e.isbuy()) achetees.add(e);
        }

        if (achetees.isEmpty()) {
            System.out.println("Aucune évolution achetée sur cette tour.");
            return;
        }

        Evolution e = (Evolution) c.choose(
            "Choisir une évolution à vendre", achetees);

        p.vendreEvolution(t, e);
    }

    @Override
    public String toString(){
        return "Vendre une Evolution";
    }
}
