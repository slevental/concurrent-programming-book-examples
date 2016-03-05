package concurrent.programming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Created by Stas on 3/5/16.
 */
public class ConcurrentTest {
    <T> void runConcurrently(Consumer<T> consumer, T[] array, int threads, int iterations) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < iterations; i++) {
            pool.execute(() -> consumer.accept(array[ThreadLocalRandom.current().nextInt(array.length)]));
        }
        pool.shutdown();
        pool.awaitTermination(Integer.MAX_VALUE, TimeUnit.HOURS);
    }

    <T> void runConcurrently(Consumer<T> consumer, T[] array, int threads) throws InterruptedException {
        runConcurrently(consumer, array, threads, threads * 1000);
    }
}
