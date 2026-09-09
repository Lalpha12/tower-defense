package TowerDefence.tower;

/**
 * Evolution that modifies the attack speed (cadence) of a tower.
 *
 * This upgrade changes the tower's shooting interval
 * by multiplying it with a given percentage value.
 */
public class EvolutionCadence extends Evolution {

    /** Percentage applied to the tower cadence. */
    private double pourcentage;

    /**
     * Creates a cadence evolution.
     *
     * @param pourcentage multiplier applied to the tower cadence
     * @param cout cost of the evolution
     */
    public EvolutionCadence(double pourcentage,double cout){
        super("Cadence", cout);
        this.pourcentage=pourcentage;
    }

    /**
     * Applies the evolution to the tower.
     * The tower cadence is multiplied by the percentage value.
     *
     * @param t the tower to upgrade
     */
    public void appliquer(Tour t) {
        t.cadence = (int)(t.cadence*pourcentage);
    }

    /**
     * Removes the evolution from the tower.
     * The tower cadence is restored by dividing
     * by the same percentage value.
     *
     * @param t the tower to downgrade
     */
    public void retirer(Tour t) {
        t.cadence =(int)(t.cadence/pourcentage);
    }

}