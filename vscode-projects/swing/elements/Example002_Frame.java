import javax.swing.JFrame;

import java.awt.Dimension;

/**
 * Example creating a frame.
 */
public class Example002_Frame {

    public static void main(String[] args) {

        // creates the window (without arguments => no title set)
        JFrame window = new JFrame("some title");

        // set the title (changes it if already there)
        window.setTitle("My first Swing-window");

        // set what happens when the 'close'-button of the window is pressed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set a size hint for the window
        window.setPreferredSize(new Dimension(400,300));
        
        // calculate the size and layout based on content
        window.pack();

        // make the window visible
        window.setVisible(true);
    }
}
