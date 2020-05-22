package cache;


public interface Cache<K, V> {


    boolean put(K key, V value,long validate);

    V get(K key);

    V remove(K key);

    void clear();

    void invalidate(K key);

}
