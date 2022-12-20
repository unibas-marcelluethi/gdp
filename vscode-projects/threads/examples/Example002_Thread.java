/** Simple thread that sleeps three seconds before it's done. */
class SleeperThread extends Thread {

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
public class Example002_Thread {

    public static void main(String[] args) {

        // Creates an object representing a thread.
        Thread thread = new SleeperThread();
        
        System.out.println("Starting thread");

        // The next line does not create a thread. It's just an ordinary call of a method
        thread.run();
        
        // // Only here, the thread is actually started
        // thread.start();
        // System.out.println("Thread started.");

        // // Wait for the thread to finish
        // try {
        //     thread.join();
        // } catch (InterruptedException ie) {
        // }

        System.out.println("Done!");
    }
}
