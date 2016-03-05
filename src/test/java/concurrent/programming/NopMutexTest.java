package concurrent.programming;

/**
 * Created by Stas on 3/5/16.
 */
public class NopMutexTest extends MutexTest {
    @Override
    protected Mutex createMutex() {
        return new Mutex() {
            @Override
            public void acquire_mutex() {
            }

            @Override
            public void release_mutex() {

            }
        };
    }
}
