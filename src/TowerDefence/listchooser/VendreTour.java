package TowerDefence.listchooser;

import TowerDefence.Player;
import TowerDefence.board.Board;
import TowerDefence.tower.Tour;
/**
 * action permettant au joueur de vendre une evolution 
 */
public class VendreTour implements Choice  {
    private final ListChooser c;
    /**
     * cree une action permettant de vendre une tour 
     * @param c le code listChooser utiliser  pour permettre au joueur selectionner une tour a vendre parmis les tours disponibles
     */
    public VendreTour(ListChooser c) {
        this.c = c;
    }

    @Override
    public void apply(Player p, Board b) {
        if (p.towers.isEmpty()) {
            System.out.println("Vous n'avez aucune tour à vendre.");
            return;
        }
        Tour t=(Tour) c.choose("Vendre une tour | credits: "+p.getCredits(),p.towers);
        t.stopTir();
        p.vendre(t,b);
    
    
    }
    @Override
    public String toString(){
        return "Vendre une Tour";
    }


}
