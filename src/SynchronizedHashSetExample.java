import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SynchronizedHashSetExample {

    public static void main(String[] args) {
        // Create a HashSet and make it synchronized
        Set<Integer> synchronizedHashSet = Collections.synchronizedSet(new HashSet<>());

        // Create multiple threads that add elements to the synchronized HashSet
        Thread thread1 = new Thread(new AddToSetTask("Thread 1", synchronizedHashSet, 1, 5));
        Thread thread2 = new Thread(new AddToSetTask("Thread 2", synchronizedHashSet, 6, 10));

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

        // Display the contents of the synchronized HashSet
        System.out.println("Final Synchronized HashSet: " + synchronizedHashSet);
    }

    // Runnable task to add elements to the synchronized HashSet
    static class AddToSetTask implements Runnable {
        private Set<Integer> synchronizedSet;
        private int start;
        private int end;
        private String thread;

        public AddToSetTask(String thread, Set<Integer> synchronizedSet, int start, int end) {
            this.synchronizedSet = synchronizedSet;
            this.start = start;
            this.end = end;
            this.thread = thread;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                synchronizedSet.add(i);
                System.out.println("Current "+ thread + " and the hashset is "+synchronizedSet+ " and the size is "+ synchronizedSet.size());
            }
        }
    }
}
