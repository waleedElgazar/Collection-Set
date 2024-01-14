import java.util.HashSet;
import java.util.Set;

public class ConcurrentHashSetExample {

    public static void main(String[] args) {
        // Create a HashSet (not synchronized)
        Set sharedHashSet = new HashSet<>();

        // Create multiple threads that add elements to the HashSet
        Thread thread1 = new Thread(new AddToSetTask("Thread 1", sharedHashSet, 1, 5));
        Thread thread2 = new Thread(new AddToSetTask("Thread 2", sharedHashSet, 6, 10));

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the contents of the HashSet
        System.out.println("Final HashSet: " + sharedHashSet);
    }

    // Runnable task to add elements to the HashSet
    static class AddToSetTask implements Runnable {
        private Set<Integer> sharedSet;
        private int start;
        private int end;
        private String thread;

        public AddToSetTask(String thread, Set<Integer> sharedSet, int start, int end) {
            this.sharedSet = sharedSet;
            this.start = start;
            this.end = end;
            this.thread = thread;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                sharedSet.add(i);
                System.out.println("Current "+ thread + " and the hashset is "+sharedSet+ " and the size is "+ sharedSet.size());
            }
        }
    }
}
