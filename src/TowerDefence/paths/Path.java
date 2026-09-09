package TowerDefence.paths;
import TowerDefence.board.*;
import java.util.ArrayList;
/**
 * The Path interface represents a strategy used to compute
 * a path on a game board.
 * 
 * This interface allows different path-finding implementations
 * (for example: fixed path, random path, horizontal/vertical path),
 * making the game easily extensible.
 */
public interface Path{
        /**
     * Computes and returns a path on the given board.
     * 
     * The path is represented as a list of cells that balloons
     * will follow in order.
     *
     * @param P the game board on which the path is computed
     * @return an ordered list of cells representing the path
     */
    ArrayList<Position> findPath(Cell[][] P);
}