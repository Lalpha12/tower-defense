package TowerDefence.listchooser;

import TowerDefence.Player;
import TowerDefence.board.Board;
/**
 * l'interface qui represente une action que le joueur peut choisir dans le jeu 
 */
public interface Choice {
    /**
     * execute l'action du joueur
     * @param p le joueur qui realise l'action
     * @param b le plateau du jeu
     */
    void apply(Player p, Board b);


}
