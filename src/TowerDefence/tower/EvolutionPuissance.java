package TowerDefence.tower;

/**
 * Evolution that increases the projectile damage of a tower.
 *
 * This upgrade adds a fixed amount of damage
 * to the current projectile.
 */
public class EvolutionPuissance extends Evolution {

    /** Damage value added to the projectile. */
    private int ajout;

    /**
     * Creates a damage evolution.
     *
     * @param ajout amount of damage to add
     * @param cout cost of the evolution
     */
    public EvolutionPuissance(int ajout,double cout ){
        super("Puissance", cout);
        this.ajout = ajout;
    }

    /**
     * Applies the evolution to the tower.
     * The projectile damage is increased.
     *
     * @param t the tower to upgrade
     */
    public void appliquer(Tour t){
        t.projectile.setDamage(t.projectile.getDamage() + ajout);
    }

    /**
     * Removes the evolution from the tower.
     * The projectile damage is decreased
     * by the same added value.
     *
     * @param t the tower to downgrade
     */
    public void retirer(Tour t) {
        t.projectile.setDamage(t.projectile.getDamage() - ajout);
    }
    
}