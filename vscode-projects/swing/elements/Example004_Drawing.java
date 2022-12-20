import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;

// new imports for this example
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Own panel class drawing itself.
 */
class MyFirstDrawing extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw a rectangle
        g.setColor(Color.GREEN);
        g.fillRect(20,30,100,40);

        // draw some text
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
        g.drawString("hi there", 20, getHeight()-20);
        
    //     //Graphics2D offers more than Graphics
    //     Graphics2D g2 = (Graphics2D) g;

    //     // just to demo something
    //     g2.shear(0.0, 0.05);
    //     g2.setRenderingHint(
    //         RenderingHints.KEY_TEXT_ANTIALIASING,
    //         RenderingHints.VALUE_TEXT_ANTIALIAS_ON
    //     );
    //     g.setColor(Color.BLUE);
    //     g.drawString("hi there", 20, getHeight()-20);
    }

}

/**
 * Example of using an own panel which draws its content.
 */
public class Example004_Drawing {
    
    public static void main(String[] args) {
        
        // create our JPanel that will draw things
        JPanel myPanel = new MyFirstDrawing();

        JFrame window = new JFrame("Drawing example");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(400,300));
        window.setContentPane(myPanel); // <- the panel is added here
        window.pack();
        window.setVisible(true);
    }
}
