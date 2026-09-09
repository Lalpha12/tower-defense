package TowerDefence.listchooser;

import TowerDefence.Player;
import TowerDefence.board.Board;
/**
 * la classe permettant de lancer une action du jeu
 */
public class Jouer implements Choice {
    
    /**
     * cree une action du jeu 
     */
    public Jouer( ) {
        
    }

    @Override
    public void apply(Player p, Board b){
  
    }

    @Override
    public String toString() { return "Jouer"; }
}