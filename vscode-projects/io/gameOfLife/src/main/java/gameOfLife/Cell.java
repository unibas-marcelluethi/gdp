package gameOfLife;

import java.awt.Point;
import java.util.List;
import java.util.Arrays;

/** A cell which knows its neighbours. */
public class Cell {

    /** Default a cell is its own neighbour in all directions. */
    private List<Cell> neighbours = Arrays.asList(
        new Cell[]{this, this, this, this, this, this, this, this}
        );
    
    /** State of the cell, with default not alive. */
    private State state = State.DEAD;

    /** Position of the cell in the grid, with default 0,0. */
    private Point position = new Point(0,0);

    /** If the state of the cell will change. */
    private boolean willChange = false;

    /** Create a cell with a given position and state. */
    public Cell(Point position, State state) {
        this.state = state;
        this.position = position;
    }

    /** Returns the position. */
    public Point getPosition() {
        return position;
    }

    /** Count the number of alive neighbours. */
    private int countAliveNeighbours() {
        int alive = 0;
        for(Cell n : neighbours) {
            if( n.state == State.ALIVE) {
                alive += 1;
            }
        }
        return alive;
    }
    
    /** Checks if the state of the cell will change on an update. */
    public boolean needsUpdate() {
        int alive = countAliveNeighbours();

        willChange = 
          (state == State.DEAD && alive == 3) ||
          (state == State.ALIVE && !(alive == 2 || alive == 3));

        return willChange;
    }

    /** Updates the state.
     * Todo: Check if willChange is actually needed or if it can be removed.
     */
    public void update() {
        if( willChange ) {
            state = state.next();
            willChange = false;
        }
    }

    /** Returns the neighbours of the cell. */
    public List<Cell> getNeighbours() {
        return neighbours;
    }

    /** Returns if the cell is alive or not. */
    public boolean isAlive() {
        return state == State.ALIVE;
    }

    /** Set the cell to given state. */
    public void setAlive(boolean alive) {
        if( alive ) {
            state = State.ALIVE;
        } else {
            state = State.DEAD;
        }
    }

    /** Set neighbouring cell top left. */
    public void setNorthWest(Cell neighbour) {
        neighbours.set(0,neighbour);
    }

    /** Get neighbouring cell top left. */
    public Cell getNorthWest() {
        return neighbours.get(0);
    }

    /** Set neighbouring cell above. */
    public void setNorth(Cell neighbour) {
        neighbours.set(1, neighbour);
    }

    /** Get neighbouring cell above. */
    public Cell getNorth() {
        return neighbours.get(1);
    }

    /** Set neighbouring cell top right. */
    public void setNorthEast(Cell neighbour) {
        neighbours.set(2, neighbour);
    }

    /** Get neighbouring cell top right. */
    public Cell getNorthEast() {
        return neighbours.get(2);
    }

    /** Set neighbouring cell right. */
    public void setEast(Cell neighbour) {
        neighbours.set(3, neighbour);
    }

    /** Get neighbouring cell right. */
    public Cell getEast() {
        return neighbours.get(3);
    }

    /** Set neighbouring cell bottom right. */
    public void setSouthEast(Cell neighbour) {
        neighbours.set(4, neighbour);
    }

    /** Get neighbouring cell bottom right. */
    public Cell getSouthEast() {
        return neighbours.get(4);
    }

    /** Set neighbouring cell below. */
    public void setSouth(Cell neighbour) {
        neighbours.set(5, neighbour);
    }

    /** Get neighbouring cell below. */
    public Cell getSouth() {
        return neighbours.get(5);
    }

    /** Set neighbouring cell bottom left. */
    public void setSouthWest(Cell neighbour) {
        neighbours.set(6, neighbour);
    }

    /** Get neighbouring cell bottom left. */
    public Cell getSouthWest() {
        return neighbours.get(6);
    }
    
    /** Set neighbouring cell left. */
    public void setWest(Cell neighbour) {
        neighbours.set(7, neighbour);
    }
    
    /** Get neighbouring cell left. */
    public Cell getWest() {
        return neighbours.get(7);
    }

}
