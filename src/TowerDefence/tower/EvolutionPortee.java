package TowerDefence.tower;

/**
 * Evolution that modifies the range (portée) of a tower.
 *
 * This upgrade changes a tower attribute using
 * a percentage multiplier.
 */
public class EvolutionPortee extends Evolution{

    /** Percentage applied to the tower attribute. */
    private double pourcentage;

    /**
     * Creates a range evolution.
     *
     * @param pourcentage multiplier applied to the tower
     * @param cout cost of the evolution
     */
    public EvolutionPortee(double pourcentage,double cout){
        super("Portee", cout);
        this.pourcentage=pourcentage;
    }

    /**
     * Applies the evolution to the tower.
     * The tower attribute is multiplied by the percentage value.
     *
     * @param t the tower to upgrade
     */
    public void appliquer(Tour t) {
        t.portee +=t.portee* pourcentage;
    }

    /**
     * Removes the evolution from the tower.
     * The tower attribute is restored by dividing
     * by the same percentage value.
     *
     * @param t the tower to downgrade
     */
    public void retirer(Tour t) {
        t.portee /= pourcentage;
    }
}