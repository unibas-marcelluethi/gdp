/** Simple runnable that sleeps three seconds before it's done. */
class SleepingRunnable implements Runnable {

    /** The run methode specifies what the thread will do. */
    @Override
    public void run() {
        System.out.println("Start sleeping in Thread ...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
        System.out.println("... done finally!");
    }
    
}

/** Main class of the example. */
public class Example003_Runnable {
    
    public static void main(String[] args) {

        // Creates a runnable object, which defines what should be done in the thread.
        Runnable runnable = new SleepingRunnable();

        // Create the thread and pass the runnable object to it.
        Thread thread = new Thread(runnable);

        System.out.println("Starting thread");
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException ie) {
        }

        System.out.println("Done!");
    }
}
