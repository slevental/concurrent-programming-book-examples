package concurrent.programming;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

/**
 * Created by Stas on 3/5/16.
 */
public abstract class MutexTest extends ConcurrentTest {
    static final int N = 1000;

    private final int threads;
    private MutableObject[] mutableObjects;


    public MutexTest(int threads) {
        this.threads = threads;
    }

    public MutexTest() {
        this(Runtime.getRuntime().availableProcessors() * 4);
    }

    @Before
    public void setUp() throws Exception {
        mutableObjects = new MutableObject[N];
        for (int i = 0; i < N; i++) {
            mutableObjects[i] = new MutableObject(createMutex());
        }
    }

    @Test
    public void test_atomicity() throws Exception {
        runConcurrently(s -> {
            try {
                s.mutex.acquire_mutex();
                s.sharedState++;
                s.mutex.release_mutex();
            } finally {
                s.atomicState.incrementAndGet();
            }
        }, mutableObjects, threads, 1000000);

        assertAtomicity(mutableObjects);
    }

    private static void assertAtomicity(MutableObject[] mutableObjects) {
        for (MutableObject object : mutableObjects) {
            assertEquals(object.atomicState.get(), object.sharedState);
        }
    }

    private static class MutableObject {
        final AtomicInteger atomicState = new AtomicInteger();
        final Mutex mutex;
        int sharedState;

        private MutableObject(Mutex mutex) {
            this.mutex = mutex;
        }
    }

    protected abstract Mutex createMutex();
}