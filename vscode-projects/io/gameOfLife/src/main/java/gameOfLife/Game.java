package gameOfLife;

import java.awt.Point;
import java.util.Iterator;
import java.util.HashSet;

import java.io.*;

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
        init(width, height);
        setGlider();
    }

    public void init(int width, int height) {
        this.height = height;
        this.width = width;
        createCells();
        cellsToUpdate = new HashSet<Cell>();
        aliveCells = new HashSet<Cell>();
    }

    /** The number of alive cells in the current game. */
    public int nAliveCells() {
        return aliveCells.size();
    }

    /** Returns an iterator over alive cells. */
    public Iterator<Cell> aliveCells() {
        return aliveCells.iterator();
    }

    /** Get the width of the field. */
    public int getWidth() { return width; }
    
    /** Get the height of the field. */
    public int getHeight() { return height; }

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
    private void setGlider() {
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
        cellsToUpdate.add(cell);
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

    public void serialize(java.io.File file) {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(height);
            dos.writeInt(width);
            aliveCells().forEachRemaining((c) -> {
                try {
                    dos.writeInt((int)c.getPosition().getX());
                    dos.writeInt((int)c.getPosition().getY());
                } catch (Exception e) { }
            } );
        } catch (IOException ie) { }
    }

    public void deserialize(java.io.File file) {
        int height = -1;
        int width = -1;
        try(DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            height = dis.readInt();
            width = dis.readInt();
            init(width, height);
            try{
                while (true) {
                    int x = dis.readInt();
                    int y = dis.readInt();
                    setAlive(x,y);
                }
            } catch (Exception e) { }
        } catch (IOException ie) { }
    }
    
}
