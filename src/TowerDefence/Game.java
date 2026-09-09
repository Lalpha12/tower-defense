package TowerDefence;
import TowerDefence.Balloon.Balloon;
import TowerDefence.Balloon.BasicBalloon;
import TowerDefence.board.Board;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the main game engine.
 * 
 * The Game class is responsible for:
 * - Creating balloons
 * - Adding them to the board
 * - Managing the game loop
 * - Moving balloons at each tick
 * - Detecting when balloons leave the board
 * 
 * The game stops automatically when all balloons have exited the board.
 */
public class Game{
    /** la joueur courant  */
    protected Player p;
    /** The game board */
    protected  Board b;
    /** Number of balloons to generate */
    protected int n;
    /** List of balloons currently in the game */
    ArrayList<Balloon>listeBallon;
    /**
     * Constructs a Game with a given board and number of balloons.
     * 
     * Balloons are created with:
     * - Random speed
     * - Random resistance between 1 and 3
     * - Unique identifier
     *
     * @param b the board on which the game runs
     * @param nbBallons number of balloons to generate
     */
    public Game(Board b,int nbBallons){
      this.b=b;
      this.n=nbBallons;
      this.listeBallon = new ArrayList<>();
      this.p=new Player();  
   

    }
    /**
     * cree les ballons pour la partie
     */
    public void createBalloons(){
        this.listeBallon=new ArrayList<>();
         Random rand = new Random();
      for (int i = 1; i <= this.n; i++) {
            float speed = 0.5f + rand.nextFloat() * 2.0f; // vitesse aléatoire
            this.listeBallon.add(new BasicBalloon(speed, rand.nextInt(10)+1,"Ballon "+i+":"));
        }
    }
      /**
     * Starts and runs the game loop.
     * 
     * The method:
     * 1. Adds all balloons to the board.
     * 2. Repeatedly moves each balloon.
     * 3. Removes balloons that reach the end of the path.
     * 4. Displays when a balloon exits the board and at what time.
     * 
     * The loop stops when no balloons remain on the board.
     */
public void play() {

    // Ajouter les ballons au plateau
    this.createBalloons();
    this.b.addBalloon(this.listeBallon);

    // Boucle principale du jeu
    while (!this.b.listeBallon.isEmpty()) {

        // Parcours à l’envers pour supprimer sans bug
        for (int i = this.b.listeBallon.size() - 1; i >= 0; i--) {

            Balloon ballon = this.b.listeBallon.get(i);

            // Déplacer le ballon
            this.b.move(ballon);

            // Si ballon sorti du plateau
            if (ballon.isOut()) {
                System.out.println(ballon.getTime() + " : "
                                   + ballon.getId() + " est sorti");
                
                this.p.diminueVieDe(1);
                this.b.removeBalloon(ballon);   // enlève de la cellule + board
                 // enlève de la liste du jeu
                continue;
            }

            // Si ballon détruit
            if (ballon.isDestroyed()) {
                // PAS d’affichage ici : déjà fait dans Balloon.takeDamage()
                this.b.removeBalloon(ballon);
                // enlève de la liste du jeu
                continue;
            }
        }

        // Petit délai pour éviter que la boucle tourne trop vite
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Fin de partie
    System.out.println("\nTous les ballons ont terminé leur parcours !");
}

}