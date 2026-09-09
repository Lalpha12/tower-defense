package TowerDefence;

import TowerDefence.board.Board;
import TowerDefence.board.Position;
import TowerDefence.tower.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * lance une partie du jeu 
 */
public class Game1 extends Game {

    /** List of towers currently used in the game. */
    ArrayList<Tour> towers;

    /**
     * Constructs a Game1 instance.
     *
     * It creates a list of towers (typically two copies of each basic tower type),
     * then randomly places them on the board using {@code putTower}.
     *
     * @param b the board used for this game mode
     * @param n the number of balloons (or waves) handled by the superclass Game
     */
    public Game1(Board b, int n) {
        super(b, n);

        Random r = new Random();
        int x;
        int y;
        towers = new ArrayList<>();

        // Creation of towers (two instances for several types)
        SingeFlechettes fleche = new SingeFlechettes();
        SingeFlechettes fleche1 = new SingeFlechettes();

        SingeTireurElite tireur = new SingeTireurElite();
        SingeTireurElite tireur1 = new SingeTireurElite();

        TourelleAiguille aiguille = new TourelleAiguille();
        TourelleAiguille aiguille1 = new TourelleAiguille();

        Gorille gorille = new Gorille();
        TourBombe bombe = new TourBombe();

        TourRballoon ralentit = new TourRballoon(5);
        TourRballoon ralentit2 = new TourRballoon(9);

        TourfrozenBalloon frozen = new TourfrozenBalloon(4);
        TourfrozenBalloon frozen2 = new TourfrozenBalloon(9);

        // Add towers to the list
        towers.add(fleche);
        towers.add(fleche1);
        towers.add(tireur);
        towers.add(tireur1);
        towers.add(aiguille);
        towers.add(aiguille1);
        towers.add(bombe);
        towers.add(gorille);
        towers.add(frozen);
        towers.add(ralentit);
        towers.add(frozen2);
        towers.add(ralentit2);

        // Random placement of towers on the board
        for (Tour t : this.towers) {
            x = r.nextInt(this.b.getNbLigne());
            y = r.nextInt(this.b.getNbColonne());
            Position p=new Position(x, y);
            // Retry until a valid position is found
            while (!(this.b.putTower(t, p))) {
                x = r.nextInt(this.b.getNbLigne());
                y = r.nextInt(this.b.getNbColonne());
                p=new Position(x, y);
            }
        }
    }

    /**
     * Runs the game.
     *
     * Before starting the main game loop (super.play()), each tower starts
     * its automatic shooting process. After the loop ends, each tower stops shooting.
     */
    public void play() {
        for (Tour t : this.towers) {
            t.startTir(this.b);
        }

        super.play();

        for (Tour t : this.towers) {
            t.stopTir();
        }
    }
  
    /**
     * retourns les tours du jeu
     * @return les tours du jeu 
     */
     public ArrayList<Tour>getTours(){
         return this.towers;
     }
      /**
       * affiche les manches du jeu 
       * @param nbNombre le nombre de manche du jeu a afficher 
       */
      protected void  display_manche(int nbNombre){
    
        for(int manche =1 ;manche<=nbNombre ;manche++){
            System.out.println("\n===Manche"+ manche+ "===");

            if(manche<=5){
                for(Tour tower:this.getTours()){
                    tower.towersApplication();
                }
            }

            else{
                for (Tour tower :this.getTours()){
                    tower.towers_revome();
                }
            }
            this.play();
        }
  }



}
