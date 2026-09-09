package TowerDefence.tower;
  /**
     * represents a projectile used by a tower
     * A projectile has :
     * a name(type of attack)
     * a damage value
     */
public class Projectile {
    //attribut 
    private int damage;
    //attribut 
    private String name;

  /**
   * constructor 
   * @param name the name of projectile
   * @param damage the damage value inflicted on impact 
   */
    public Projectile(String name,int damage) {
        this.damage = damage;
        this.name=name;

    }

    /**
     * it's getteur 
     * @return damage value of the projectile
     */
    public int getDamage() {
        return damage;
    }
    /**
     * updates the damage value
     * @param damage  new damage amount 
     */
    public void setDamage(int damage){
        this.damage= damage;
    }
    /**
     * it's the getteurs
     * @return name of the projectile
     */
    public String getName(){
        return this.name;
    }
}