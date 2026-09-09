package TowerDefence;

import TowerDefence.board.Board;
import TowerDefence.tower.Evolution;
import TowerDefence.tower.Tour;
import java.util.ArrayList;
import java.util.Random;
/**
 * la classe player 
 */
public class Player {
/**
les credits du joueur pour acheter des tours 
 */
protected double credits;
/**
le nombre de vie qu'un joueur peut avoir 
*/
protected int vies;
/**
la liste des tours  
*/
public ArrayList<Tour>towers;
/**
 * le constructeur de la classe player  
 * */
public Player(){
    this.credits=999999999;
    this.vies=205555;
    this.towers=new ArrayList<>();
}
/** 
* Adds credits to the player's balance (e.g. after destroying a balloon).
*
* @param amount amount to add
*/
public void ajouterCredits(double amount) {
    this.credits += amount;
    System.out.println("Credits +" + amount + " → total : " + this.credits);
}

/**
 * Returns the current credits of the player.
 *
 * @return credits
 */
public double getCredits() {
    return this.credits;
}

/**
 * Sets the player's credits to a specific value.
 * This method is mainly used for testing or controlled updates.
 *
 * @param credits the new amount of credits to assign to the player
 */
public void setCredits(double credits) {
    this.credits = credits;
}
/**
 * Decrements the player's lives by the given amount.
 * Lives cannot go below 0.
 *
 * @param amount number of lives to lose
 */
public void diminueVieDe(int amount) {
    this.vies -= amount;
    if (this.vies < 0) {
        this.vies = 0;
    }
    System.out.println("Vie perdue ! Vies restantes : " + this.vies);
}
/**
 * renvoie le nombre de vie que detient un joueur
 * @return le nombre de vie d'un joueur 
 */
public int getVie(){
    return this.vies;
}
/**
 * Attempts to buy a tower.
 * Deducts the tower cost from credits if the player can afford it.
 *
 * @param t the tower to buy
 * @return true if purchase succeeded, false if not enough credits
 */
public boolean acheter(Tour t) {
    if (this.credits >= t.getCout()) {
        this.credits -= t.getCout();
        this.towers.add(t); 
        System.out.println("Tour achetée : " + t.getClass().getSimpleName()
                + " | Coût : " + t.getCout()
                + " | Crédits restants : " + this.credits);
        return true;
    }
    System.out.println("Crédits insuffisants pour acheter "
            + t.getClass().getSimpleName()
            + " (coût : " + t.getCout() + ", crédits : " + this.credits + ")");
    return false;
}
/**
 * Attempts to buy an evolution for a given tower.
 * The evolution is applied immediately if the player can afford it
 * and the evolution has not already been purchased.
 *
 * @param t the tower to evolve
 * @param e the evolution to apply
 * @return true if the evolution was bought and applied, false otherwise
 */
public boolean acheterEvolution(Tour t, Evolution e) {

    if (this.credits < e.getCout()) {
        System.out.println("Crédits insuffisants pour l'évolution "
                + e.getNom()
                + " (coût : " + e.getCout() + ", crédits : " + this.credits + ")");
        return false;
    }
    this.credits -= e.getCout();
    e.appliquer(t);
    e.buy();
    t.getEvolutions().add(e);
    System.out.println("Évolution achetée : " + e.getNom()
            + " sur " + t.getClass().getSimpleName()
            + " | Crédits restants : " + this.credits);
    return true;
}    
    /**
     * action pour vendre une tour 
     * @param t la tour a vendre 
     * @param b le plateau de jeu 
     * @return true si et seulement la tour a été vendu correctement 
     */
    public boolean vendre(Tour t,Board b) {
   
     	//Sum of the all buyed  evolution
        for (Evolution e : t.getEvolutions()) {
            if (e.isbuy()) {
                double remboursement = e.getCout() ;
                this.credits += remboursement;
            }
        }
     
        this.credits += t.getCout();
        this.towers.remove(t);
        System.out.println("Tour vendue : " + t.getClass().getSimpleName()
                + " | Remboursement : " + t.getCout()
                + " | Crédits : " + this.credits);
        /*int x=t.getPosition().getNbLigne();
        int y=t.getPosition().getNbColonne();
        b.getCell(x,y).setvalueX(null);*/
        return true;
    }
    /**
     * action pour vendre une evolution 
     * @param t la tour concernée par la vente de l'evolution 
     * @param e l'evolution a vendre et qui est retiré de la tour 
     * @return true si et seulement si la vente s'est bien deroulé 
     */
    public boolean vendreEvolution(Tour t, Evolution e) {
  
        this.credits +=  e.getCout();
        e.retirer(t);
        e.unbuy();
        System.out.println("Évolution vendue : " + e.getNom()
                + " | Remboursement : " + e.getCout()
                + " | Crédits : " + this.credits);
        return true;
    }

    @Override
    public String toString() {
        return "Joueur | Crédits : " + this.credits + " | Vies : " + this.vies;
    }
    /**
     * la methode qui verifie si le joueur est toujour en vie (si il a toujour des vies )
     * @return true si le joueur est toujours en vie c'est - dire si sa vie est superieur à 0
     */
    public boolean isAlive(){
        return this.vies>0;
    }
}






