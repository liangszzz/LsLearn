package cache;


public interface Cache<K, V> {


    boolean put(K key, V value);

    V get(K key);

    int remove(K key);

    void clear();

    void invalidate(K key);

}
