package concurrent.programming;

/**
 * Created by Stas on 3/5/16.
 */
public interface Mutex {
    void acquire_mutex();

    void release_mutex();
}
