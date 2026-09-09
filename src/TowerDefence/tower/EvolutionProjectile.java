package TowerDefence.tower;

/**
 * Evolution that changes the projectile of a tower.
 *
 * This upgrade replaces the current projectile
 * with a new one and allows restoring the old one.
 */
public class EvolutionProjectile extends Evolution {

    /** The new projectile applied to the tower. */
    private Projectile nouveau;

    /** The previous projectile (saved to allow restoration). */
    private Projectile ancien;

    /**
     * Creates a projectile evolution.
     *
     * @param p the new projectile to apply
     * @param cout cost of the evolution
     */
    public EvolutionProjectile(Projectile p, double cout) {
        super("Nouveau projectile", cout);
        this.nouveau = p;
    }

    /**
     * Applies the evolution to the tower.
     * The current projectile is saved and replaced
     * with the new projectile.
     *
     * @param t the tower to upgrade
     */
    public void appliquer(Tour t) {
        ancien = t.projectile;
        t.projectile = nouveau;
    }

    /**
     * Removes the evolution from the tower.
     * The previous projectile is restored.
     *
     * @param t the tower to downgrade
     */
    public void retirer(Tour t) {
        t.projectile = ancien;
    }
    
}