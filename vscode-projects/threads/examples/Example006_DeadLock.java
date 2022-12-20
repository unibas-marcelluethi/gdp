/** Main program of the example. */
public class Example006_DeadLock {

    public static void main(String[] args) {

        // Dinner with not enough cutlery.
        Fork fork = new Fork();
        Knife knife = new Knife();
        Thread anna = new Person("Anna", fork, knife, true);
        Thread otto = new Person("Otto", fork, knife, false);

        // start threads
        anna.start();
        otto.start();

        // thread will wait forever, you have to terminate the program manually
    }
}

/** Simple class that helps when there is something to eat on the table. */
class Cutlery {
    private boolean isTaken = false;

    void take() {
        isTaken = true;
    }

    void release() {
        isTaken = false;
    }

    boolean isTaken() {
        return isTaken;
    }
 }

 /** A fork, might be usefull to eat something. */
 class Fork extends Cutlery { }
 /** A knife, might be usefull to eat something. */
 class Knife extends Cutlery { }

/** From Thread derived class that produces somethings and puts it on the stock. */
class Person extends Thread {
    private Fork fork;
    private Knife knife;
    private boolean grabsForkfirst;
    private String name;

    /** Create producer using a certain stock. */
    Person(String name, Fork fork, Knife knife, boolean grabsForkfirst) {
        this.fork = fork;
        this.knife = knife;
        this.grabsForkfirst = grabsForkfirst;
        this.name = name;
    }

    /** What the producer does. */
    @Override
    public void run() {
        while(true) {
            if (grabsForkfirst) {
                grabForkThenKnife();
            } else {
                grabKnifeThenFork();
            }
        }
    }

    /** Try hard to take something from the table to eat */
    void take(Cutlery thing) {
        synchronized(thing) {
            while(true) {
                if(thing.isTaken()) {
                    try {
                        System.out.println(name + " - waiting for " + thing.getClass().getSimpleName());
                        thing.wait();
                    } catch (Exception e) {}
                } else {
                    thing.take();
                    break;
                }
            }
        }
    }

    /** Realsing should not be a problem, if we are sure that we have it. */
    void release(Cutlery thing) {
        synchronized(thing) {
            thing.release();
            thing.notify();
        }
    }

    /** Grabs first the fork then the knife. */
    void grabForkThenKnife() {
        take(fork);
        take(knife);
        System.out.println(name + " - mmmhhhh it was time to eat something!");
        release(knife);
        release(fork);
        sleepFor(20);
    }

    /** Grabs first the knife then the fork */
    void grabKnifeThenFork() {
        take(knife);
        take(fork);
        System.out.println(name + " - mmmhhhh it was time to eat something!");
        release(fork);
        release(knife);
        sleepFor(20);
    }

    /** Sleeps for a second - we can't just consume all the time. */
    static void sleepFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) { }
    }
}