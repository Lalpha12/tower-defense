package TowerDefence.listchooser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * implemntation de la classe qui choisit aleatoirement un element de la liste 
 * @param <T> type des elements de ma liste 
 */
public class RandomListChooser<T> implements ListChooser<T> {
    /**
     * constructeur de ma classe 
     */
    public RandomListChooser(){}

    private final Random random = new Random();

    /**
     * Chooses randomly among the items in the list, or null ("none").
     *
     * Null is injected as an extra candidate so it can be selected just
     * like any real item.  If the list is empty, null is always returned.
     *
     * @param msg  the question displayed before the choice
     * @param list the list of items to choose from
     * @return a randomly chosen item, or null
     */
   public T choose(String msg, List<? extends T> list) {
    if (list.isEmpty()) return null;

    System.out.println(msg);
    int index = 1;
    for (T element : list) {
        System.out.print(index == 1 ? "[" : ", ");
        System.out.print((index++) + " - " + element);
    }
    System.out.println("]");

    T chosen = list.get(random.nextInt(list.size()));
    System.out.println("  → choix automatique : " + chosen);
    return chosen;
}
}
