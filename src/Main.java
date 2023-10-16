public class Main {

    public Counter counter = new Counter();

    class Counter {
        public int count;
        public void increment() {
            count++;
        }
        public int getValue() {
            return this.count;
        }
    }
    public void startThreads() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(counter.getValue());
    }

    public static void main(String[] args) throws InterruptedException{
        Main main = new Main();
        main.startThreads();
        
    }
}