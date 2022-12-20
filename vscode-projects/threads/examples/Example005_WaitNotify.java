// TODO
// - Why does the producer check only every second to add products?
// - Does calling 'notify' trigger an InterruptException at the location of the 'wait'?
// - Is the 'stock.notify();' nescessary in the Producer?
// - In which situation is the 'stock.notify();' needed in the Producer?
// - The notify and stock methods are called on the stock object. Why? Is it possible without specifying the stock object?

/** Example class to simulate a stock which holds some data. */
class Stock {
    final int MAX_CAPACITY = 10;
    int products = 5;

    /** Adds to the stock. */
    void put(int amount) {
        products += amount;
    }

    /** Removes from the stock. */
    void get(int amount) {
        products -= amount;
    }

    /** Checks if there is enough space. */
    boolean hasSpaceFor(int amount) {
        return products + amount <= MAX_CAPACITY;
    }

    /** Checks if there is enough in the stock. */
    boolean has(int amount) {
        return amount <= products;
    }
}

/** From Thread derived class that produces somethings and puts it on the stock. */
class Producer extends Thread {
    private Stock stock;

    /** Create producer using a certain stock. */
    Producer(Stock stock) {
        this.stock = stock;
    }

    /** What the producer does. */
    @Override
    public void run() {
        while(true) {
            int producedProducts = 5;
            putInStorage(producedProducts);
        }
    }

    /** Synchronized access, that waits for enough space. */
    void putInStorage(int amount) {
        synchronized(stock) {
            while(true) {
                if(stock.hasSpaceFor(amount)) {
                    stock.put(amount);
                    System.out.println("Producer: " + amount + " -> " + stock.products);
                    stock.notify();
                    break;
                } else {
                    try{
                        System.out.println("Producer - waiting!");
                        stock.wait();
                    } catch (InterruptedException ie) { }
                }
            }
        }
    }
}


/** From Thread derived class that consumes some product. */
class Consumer extends Thread {
    private Stock stock;

    /** Creates a consumer using a specific stock. */
    Consumer(Stock stock) {
        this.stock = stock;
    }

    /** What the consumer does. */
    @Override
    public void run() {
        while(true) {
            takeFromStorage(1);
            sleepForASecond();
        }
    }

    /** Synchronized access, that waits for enough products. */
    void takeFromStorage(int need) {
        synchronized(stock) {
            while(true) {
                if(stock.has(need)) {
                    stock.get(need);
                    System.out.println("Consumer: " + need + " -> " + stock.products);
                    stock.notify();
                    break;
                } else {
                    try{
                        stock.wait();
                    } catch (InterruptedException ie) {
                    }
                }
            }
        }
    }

    /** Sleeps for a second - we can't just consume all the time. */
    static void sleepForASecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
    }
}

/** Main program of the example. */
public class Example005_WaitNotify {

    public static void main(String[] args) {

        // setup producer-storage-consumer situation
        Stock s = new Stock();
        Thread producer = new Producer(s);
        Thread consumer = new Consumer(s);

        // start threads
        producer.start();
        consumer.start();

        // thread running forever, you have to kill the program manually
    }
}