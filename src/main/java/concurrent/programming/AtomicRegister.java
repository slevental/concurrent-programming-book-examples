package concurrent.programming;

/**
 * Created by Stas on 3/5/16.
 */
public interface AtomicRegister<Type> {
    void write(Type var);

    Type read();
}
