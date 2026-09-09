package TowerDefence.listchooser;

import TowerDefence.listchooser.util.Input;
import java.util.List;
/**
 * implementation de la classe permettant de choisir un element dans une liste de maniere interactive
 * @param <T> type des elements de ma liste 
 */
public class InteractiveListChooser<T> implements ListChooser<T> {
    /**
     * le constructeur par defaut 
     */
    public InteractiveListChooser(){

    }
	/**
	 * Allows one to choose an item from a list of items of type T.
	 * If the list of items is empty, null is returned.
	 * The list of items is presented as numbers followed by the 
	 * string representation of the item. 
	 * The possibility not to make a choice is automatically added (choice number 0), 
	 * in this case, null is returned.
	 * 
	 * @param msg The asked question.
	 * @param list The list of items of type T from which one must choose one.
	 * @return The chosen item. null if the list of items is empty or if the user chooses not to make no choice
	 */
public T choose(String msg, List<? extends T> list) {
    if (list.isEmpty()) return null;

    int choice = -1;
    while (choice < 1 || choice > list.size()) {
        System.out.println(msg);
        int index = 1;
        for (T element : list) {
            System.out.println("      " + (index++) + " - " + element);
        }
        System.out.println("            choix ?");
        try {
            choice = Input.readInt();
            if (choice < 1 || choice > list.size()) {
                System.out.println("Entrez un numéro entre 1 et " + list.size() + ".");
            }
        } catch (java.io.IOException e) {
            System.out.println("Entrez un numéro entre 1 et " + list.size() + ".");
        }
    }
    return list.get(choice - 1);
}
}
