import javax.swing.JOptionPane;

/**
 * Example of using dialogs to interact with the user.
 */
public class Example001_Dialog {

    public static void main(String[] args) {

        // Simple dialog to inform the user. Closes after pressing OK.
        // There is no parent, so we pass in null as first argument.
        JOptionPane.showMessageDialog(null, "Welcome to GdP");

        // // Input dialog to promt the user to enter something. Returns a String.
        // String input = JOptionPane.showInputDialog(null, "Please enter a number");

        // System.out.println("You entered: " + input);
    }
}