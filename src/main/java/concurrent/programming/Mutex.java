package concurrent.programming;

/**
 * Created by Stas on 3/5/16.
 */
public interface Mutex {
    void acquire_mutex(int i);

    void release_mutex(int i);

    default void acquire_mutex() {
        acquire_mutex(getId());
    }

    default void release_mutex() {
        release_mutex(getId());
    }

    default int getId() {
        return (int) Thread.currentThread().getId();
    }
}
