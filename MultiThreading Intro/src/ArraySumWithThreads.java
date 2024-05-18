import java.util.concurrent.*;

public class ArraySumWithThreads {
    public static void main(String[] args) {
        int[] array = { 53, 04, 14, 37, 39, 10, 52, 59, 16, 61 };
        int numThreads = 4; // Number of threads to use

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Create a thread pool with the specified number of threads
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Create an array to hold the results of each thread
        Future<Integer>[] results = new Future[numThreads];

        // Divide the array into equal parts for each thread
        int chunkSize = array.length / numThreads;

        // Submit tasks to the executor
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? array.length : (i + 1) * chunkSize;
            Callable<Integer> task = new SumTask(array, start, end);
            results[i] = executor.submit(task);
        }

        // Sum up the results from each thread
        int sum = 0;
        for (Future<Integer> result : results) {
            try {
                sum += result.get(); // Wait for the result of each thread and add it to the total sum
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor
        executor.shutdown();

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate and print the total execution time
        long totalTime = endTime - startTime;
        System.out.println("Sum of the array: " + sum);
        System.out.println("Total execution time: " + totalTime + " milliseconds");
    }
}

class SumTask implements Callable<Integer> {
    private int[] array;
    private int start;
    private int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
