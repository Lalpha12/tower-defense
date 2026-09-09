package TowerDefence;

import TowerDefence.board.Board;
import TowerDefence.listchooser.*;
import TowerDefence.tower.*;
import java.util.ArrayList;
/**classe principale du jeu final
 * elle gere les manches , les actions du joueur et le deroulement global 
 */
public class FinalGame extends Game {

    private ListChooser c;
    private ArrayList<Tour> catalogue;
    private int manche;
    private ArrayList<Choice> actions;
    private ArrayList<Tour> towers;
    /**
     * le programme de jeu final 
     * @param b le plateau de jeu final
     * @param n le nombre de manche 
     * @param c le code listChooser qui choisit une action a realiser 
     *
     */
    public FinalGame(Board b, int n, ListChooser c){
        super(b, n);

        this.c = c;
        this.manche = 1;
        this.towers=new ArrayList<>();

        // catalogue de tours
        this.catalogue = new ArrayList<>();
        this.catalogue.add(new SingeFlechettes());
        this.catalogue.add(new SingeTireurElite());
        this.catalogue.add(new TourelleAiguille());
        this.catalogue.add(new TourBombe());
        this.catalogue.add(new Gorille());
        this.catalogue.add(new TourfrozenBalloon(4));
        this.catalogue.add(new TourRballoon(3));

        // actions joueur
        this.actions = new ArrayList<>();
        this.actions.add(new AcheterTour(c, this.catalogue));
        this.actions.add(new VendreTour(c));
        this.actions.add(new AcheterEvolution(c));
        this.actions.add(new VendreEvolution(c));
        this.actions.add(new Jouer());

    }

    /**
     * Override wave generation per round
     */



    /**
     * Phase d'achat
     */
    private void phaseAchat(Player p, Board b) {

        Choice choix = (Choice) this.c.choose(
                "Que voulez-vous faire ? | Crédits : " + p.getCredits(),
                this.actions);

        while (!(choix instanceof Jouer)) {

            choix.apply(p, b);

            choix = (Choice) this.c.choose(
                    "Autre action ? | Crédits : " + p.getCredits(),
                    this.actions);
        }
    }
   

    /**
     * Main game loop
     */
    @Override
    public void play() {
    
        while (this.p.isAlive()) {
            System.out.println("\n--- Phase d'achat — Manche " + this.manche + " ---");
            this.phaseAchat(this.p, this.b);
            this.towers =this.p.towers;
            System.out.println("\n--- Combat ---");
            for (Tour t : this.towers) {
            t.startTir(this.b);
        }
            super.play();

            
             for (Tour t : this.towers) {
            t.stopTir();
        }
        this.manche++;
        }

        System.out.println("\n=== GAME OVER ===");
    }
}