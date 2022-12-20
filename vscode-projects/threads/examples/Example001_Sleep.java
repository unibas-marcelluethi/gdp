/** Main class of the example. */
public class Example001_Sleep {
    public static void main(String[] args) {

        System.out.println("Start sleeping ...");
        
        try {
            Thread.sleep(3000); // time to wait in milliseconds
        } catch (InterruptedException ie) { }

        System.out.println("... done finally!");
    }
}

// TODO
// - Change the code, so that while waiting the numbers 1, 2 and 3 are printed each after a second.