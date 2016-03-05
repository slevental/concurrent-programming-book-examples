package concurrent.programming;

/**
 * Created by Stas on 3/5/16.
 */
public class Peterson2PMutex implements Mutex {

    final boolean flag[] = new boolean[2];
    volatile int after = 0;

    @Override
    public void acquire_mutex(int i) {
        i = i % 2;
        flag[i] = true;
        after = i;
        int j = 1 - i;
        while (flag[j] && after == i) {
            flag[i] = false;
            Thread.yield();
            flag[i] = true;
        }
    }

    @Override
    public void release_mutex(int i) {
        flag[i % 2] = false;
    }
}
