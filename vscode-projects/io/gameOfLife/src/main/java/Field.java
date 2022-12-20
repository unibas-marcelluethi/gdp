import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.JButton;

import gameOfLife.Game;
import gameOfLife.Cell;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Color;

import java.io.File;

import java.util.Iterator;

public class Field extends JPanel implements MouseInputListener  {

    private JButton runButton = null;
    private boolean pausedForMouseDrawing = false;
    private boolean mouseIsDown = false;
    private Game gameField;

    public Field(int width, int height) {
        init(width, height);
    }
        
    public void init(int width, int height) {
        gameField = new Game(width, height);
        setMinimumSize(new Dimension(width, height));
    }

    public void evolve() {
        gameField.evolve();
    }
    
    public void setButton(JButton button) {
        this.runButton = button;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        Iterator<Cell> cellsToPaint = gameField.aliveCells();
        double cellWidth = getWidth() / (double) gameField.getWidth();
        double cellHeight = getHeight() / (double) gameField.getHeight();
        while(cellsToPaint.hasNext()) {
            Point pos = cellsToPaint.next().getPosition();
            
            int xStart = (int) Math.round(pos.x * cellWidth);
            int yStart = (int) Math.round(pos.y * cellHeight);
            int xEnd = (int) Math.round((pos.x + 1) * cellWidth);
            int yEnd = (int) Math.round((pos.y + 1) * cellHeight);
            g.fillRect(xStart, yStart, xEnd - xStart, yEnd - yStart);

        }
        g.setColor(Color.RED);
        g.drawString("Alive: "+gameField.nAliveCells(), 10, getHeight()-10);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point location = gameFieldCoordinates(e);
        gameField.setAlive(location.x, location.y);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseIsDown = true;
        if(runButton != null && runButton.getText() == "Stop") {
            pausedForMouseDrawing = true;
            runButton.doClick();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseIsDown = false;
        if(runButton != null && pausedForMouseDrawing) {
            runButton.doClick();
            pausedForMouseDrawing = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mouseIsDown) {
            Point location = gameFieldCoordinates(e);
            gameField.setAlive(location.x, location.y);
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    private Point gameFieldCoordinates(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();

        double cx = getWidth() / (double) gameField.getWidth();
        double cy = getHeight() / (double) gameField.getHeight();

        int posX = (int) Math.floor(x / cx);
        int posY = (int) Math.floor(y / cy);

        return new Point(posX, posY);
    }

    public void save(File file) {
        gameField.serialize(file);
    }

    public void load(File file) {
        gameField.deserialize(file);
        repaint();
    }

}