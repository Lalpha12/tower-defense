package TowerDefence.listchooser;

import java.util.List;
/**
 * interface permettant de selectionner un element dans une liste
 * @param <T> type des elements contenu dans ma liste 
 */
public interface ListChooser<T> {

	/**
	 * Allows one to choose an item from a list of items of type T. 
	 * 
	 * @param msg The asked question.
	 * @param list The list of items of type T from which one must choose one.
	 * @return The chosen item.
	 */
	public T choose(String msg, List<? extends T> list);
} 
