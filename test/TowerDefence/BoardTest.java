package TowerDefence;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import TowerDefence.board.*;
import TowerDefence.paths.*;
public class BoardTest {
    @Test
    public void testBoardCreationIsCorrect(){
        Board board = new BoardOne(10,10);
        assertEquals(10,board.getNbLigne());
        assertEquals(10,board.getNbColonne());
        Cell c = board.getCell(1,2);
        assertEquals(new Position(1, 2),c.getPosition());
        Cell c1 = board.getCell(3,0);
        assertEquals(new Position(3, 0),c1.getPosition());
        assertEquals(3,c1.getPosition().getNbLigne());
        assertEquals(2,c.getPosition().getNbColonne());
    }
    @Test
    public void testBoardOne(){
        BoardOne board1 = new BoardOne(10, 10);
        BoardOne board11 = new BoardOne(12, 13);
        assertEquals(10,board1.getNbLigne());
        assertEquals(10,board1.getNbColonne());
        assertEquals(12,board11.getNbLigne());
        assertEquals(13,board11.getNbColonne());
        Cell c2 = board1.getCell(2, 3);
        assertEquals(new Position(2,3),c2.getPosition());
        Cell c3 = board11.getCell(4, 3);
        assertEquals(new Position(4,3),c3.getPosition());
        assertEquals(4,c3.getPosition().getNbLigne());
    }

    @Test
    public void testBoardTwo(){
        BoardTwo b1 = new BoardTwo(14,15,2);
        assertEquals(14,b1.getNbLigne());
        assertEquals(15,b1.getNbColonne());
        Cell c4 = b1.getCell(2,5);
        assertEquals(new Position(2,5),c4.getPosition());
        assertEquals(5,c4.getPosition().getNbColonne());
    }
    @Test
    public void testPathIsNotEmpty() {
        int rows = 10, cols = 10;
        Cell[][] cells = new Cell[rows][cols];
        for (int i = 0;i<rows;i++){
            for (int j=0;j<cols;j++){
                cells[i][j] = new Cell(new Position(i, j));
            }
        }
        PathOne path = new PathOne();
        ArrayList<Position> res = path.findPath(cells);
        assertNotNull(res);
        assertFalse(res.isEmpty());
    }
    @Test
    public void testPathInsideGrid() {
        int rows = 6, cols = 7;
        Cell[][] cells = new Cell[rows][cols];
        for (int i = 0; i<rows;i++){
            for (int j = 0;j<cols;j++){
                cells[i][j] = new Cell(new Position(i, j));
            }
        }
        PathOne path = new PathOne();
        ArrayList<Position> res = path.findPath(cells);
        for (Position p : res) {
            assertTrue(p.getNbLigne() >= 0 && p.getNbLigne() < rows);
            assertTrue(p.getNbColonne() >= 0 && p.getNbColonne() < cols);
        }
    }
        @Test
        public void testPathLigneOrColonneIsCorrect() {
            int rows = 10;
            int cols = 10;
            Cell[][] cells = new Cell[rows][cols];
            for (int i = 0;i<rows;i++){
                for (int j = 0;j<cols;j++){
                    cells[i][j] = new Cell(new Position(i,j));
                }
            }
            Path p = new PathTwo();
            ArrayList<Position> res = p.findPath(cells);
            for (int i = 0;i<res.size()-1;i++){
                Position p1 = res.get(i);
                Position p2 = res.get(i+1);
                int dl = Math.abs(p1.getNbLigne()-p2.getNbLigne());
                int dc = Math.abs(p1.getNbColonne()-p2.getNbColonne());
                assertTrue((dl == 1 && dc ==0) || (dl==0 && dc==1));
            }
        }
    }
