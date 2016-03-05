package concurrent.programming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Stas on 3/5/16.
 */
public class JdkLockMutexTest extends MutexTest {
    @Override
    protected Mutex createMutex() {
        return new Mutex() {
            final Lock lck = new ReentrantLock();

            @Override
            public void acquire_mutex() {
                lck.lock();
            }

            @Override
            public void release_mutex() {
                lck.unlock();
            }
        };
    }
}
