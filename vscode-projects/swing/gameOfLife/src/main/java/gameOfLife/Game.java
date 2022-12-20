package gameOfLife;

import java.util.Iterator;
import java.awt.Point;
import java.util.HashSet;

/**
 * A game of live implementation.
 */
public class Game {
    private int height = 0;
    private int width = 0;
    private Cell topLeft = null;
    private HashSet<Cell> cellsToUpdate;
    private HashSet<Cell> aliveCells;
    
    /** Constructs a new game of live with given height and width. */
    public Game(int width, int height) {
        this.height = height;
        this.width = width;
        createCells();
        cellsToUpdate = new HashSet<Cell>();
        aliveCells = new HashSet<Cell>();
        init();
    }

    /** The number of alive cells in the current game. */
    public int nAliveCells() {
        return aliveCells.size();
    }

    /** Returns an iterator over alive cells. */
    public Iterator<Cell> aliveCells() {
        return aliveCells.iterator();
    }

    /** Evolve the game to the next state. */
    public void evolve() {
        HashSet<Cell> cellsThatChange = new HashSet<Cell>();
        for(Cell c: cellsToUpdate) {
            if (c.needsUpdate())
                cellsThatChange.add(c);
        }
        cellsToUpdate.clear();
        for(Cell c: cellsThatChange) {
            c.update();
            if (c.isAlive()) {
                aliveCells.add(c);
            } else {
                aliveCells.remove(c);
            }
            cellsToUpdate.addAll(c.getNeighbours());
        }
    }

    /** Set a given cell to the state alive. */
    public void setAlive(int x, int y) {
        Cell current = topLeft;
        for(;x>0; x -= 1) {
            current = current.getEast();
        }
        for(;y>0; y -= 1) {
            current = current.getSouth();
        }
        setAlive(current);
    }

    /** Initialize the game of live with a glider. */
    private void init() {
        Cell current = topLeft.getEast().getSouth();
        setAlive(current);
        current = current.getEast();
        setAlive(current);
        current = current.getEast();
        setAlive(current);
        current = current.getSouth();
        setAlive(current);
        current = current.getSouthWest();
        setAlive(current);
    }

    /** Sets a specific cell as alive. */
    private void setAlive(Cell cell) {
        cell.setAlive(true);
        aliveCells.add(cell);
        cellsToUpdate.addAll(cell.getNeighbours());
    }

    /**
     * Create a field of cells.
     */
    private void createCells() {
        Cell firstRow = null;
        Cell currentRow = null;
        for (int row = 0; row < height; row += 1 ) {
            Cell firstCell = createRow(row);
            if (row == 0) {
                firstRow = firstCell;
            } else {
                linkRows(currentRow, firstCell);
            }
            currentRow = firstCell;
        }
        linkRows(currentRow, firstRow);
        topLeft = firstRow;
    }

    /**
     * Create a row of horizontal linked cells.
     */
    private Cell createRow(int rowIndex) {
        Cell firstCell = null;
        Cell current = null;
        for (int col = 0; col < width; col += 1) {
            Cell c =  new Cell(new Point(col, rowIndex), State.DEAD);
            if ( col == 0 ) {
                firstCell = c;
            } else {
                current.setEast(c);
                c.setWest(current);
            }
            current = c;
        }
        firstCell.setWest(current);
        current.setEast(firstCell);
        return firstCell;
    }

    /**
     * Connect two rows to each other.
     */
    private void linkRows(Cell upperRow, Cell lowerRow) {
        Cell upper = upperRow;
        Cell lower = lowerRow;
        do {
            lower.setNorthWest(upper.getWest());
            lower.setNorth(upper);
            lower.setNorthEast(upper.getEast());
            upper.setSouthWest(lower.getWest());
            upper.setSouth(lower);
            upper.setSouthEast(lower.getEast());

            lower = lower.getEast();
            upper = upper.getEast();
        } while (lower != lowerRow);
    }
    
}
