import javax.swing.JFrame;
import java.awt.Dimension;

// new imports for this example
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;

/**
 * Example of adding content to a window.
 */
public class Example003_Content {

    public static void main(String[] args) {

        // create JPanel that will hold our content
        JPanel content = new JPanel();

        // create and add a layout manager
        FlowLayout layout = new FlowLayout(); // FlowLayout, like text flow on a written page
        content.setLayout(layout);

        // create and add a label
        JLabel label = new JLabel("Some information");
        content.add(label);

        // create and add button
        JButton button = new JButton("Click me");
        content.add(button);



        // create man window and add content
        JFrame window = new JFrame("Demo of content");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(400,300));
        window.setContentPane(content); // <- the content is added here
        window.pack();
        window.setVisible(true);
    }
}
