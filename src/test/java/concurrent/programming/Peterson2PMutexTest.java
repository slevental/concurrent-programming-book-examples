package concurrent.programming;

/**
 * Created by Stas on 3/5/16.
 */
public class Peterson2PMutexTest extends MutexTest {

    public Peterson2PMutexTest() {
        super(2);
    }

    @Override
    protected Mutex createMutex() {
        return new Peterson2PMutex();
    }
}
