import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Prints a String to the console when an action is performed.
 */
class ListenerImplementation implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("I got an ActionEvent.");
    }
}

/**
 * Simple re-action example.
 */
public class Example005_Events {
    public static void main(String[] args) {
        
        // creating a button, registering the action listener to it.
        JButton button = new JButton("Click me");
        button.addActionListener(new ListenerImplementation());
        
        JFrame window = new JFrame("Events example");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(button); // <- the button is added here
        window.pack();
        window.setVisible(true);
    }
}
