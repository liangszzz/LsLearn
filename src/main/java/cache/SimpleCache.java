package cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleCache implements Cache<String, SimpleCacheEntry<String>> {

    private final int max;

    private final ConcurrentHashMap<String, SimpleCacheEntry<String>> map;


    public SimpleCache(int max) {
        this.max = max;
        this.map = new ConcurrentHashMap<>(max);
    }

    @Override
    public boolean put(String key, SimpleCacheEntry<String> value) {
        return checkSize() && map.put(key, value) != null;
    }

    @Override
    public SimpleCacheEntry<String> get(String key) {
        return null;
    }

    @Override
    public SimpleCacheEntry<String> remove(String key) {
        return map.remove(key);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public void invalidate(String key) {

    }

    private boolean checkSize() {
        return this.map.size() < this.max;
    }

}

@Getter
@Setter
@AllArgsConstructor
class SimpleCacheEntry<V> {

    private V value;

    private long validate;

}
