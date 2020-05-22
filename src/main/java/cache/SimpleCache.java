package cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleCache implements Cache<String, Object> {

    private final int max;

    private final ConcurrentHashMap<String, SimpleCacheEntry<Object>> map;


    public SimpleCache(int max) {
        this.max = max;
        this.map = new ConcurrentHashMap<>(max);
    }

    @Override
    public boolean put(String key, Object value, long validate) {
        if (!checkSize()) return false;
        doPut(key, value, validate);
        return true;
    }

    private void doPut(String key, Object value, long validate) {
        SimpleCacheEntry<Object> simpleCacheEntry = new SimpleCacheEntry<>(value, validate);
        map.put(key, simpleCacheEntry);
    }

    @Override
    public SimpleCacheEntry<String> get(String key) {
        return null;
    }

    @Override
    public Object remove(String key) {
        SimpleCacheEntry<Object> remove = map.remove(key);
        if (remove.getValidate() > System.currentTimeMillis()) {
            return remove.getValue();
        }
        return null;
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

    @Getter
    @Setter
    @AllArgsConstructor
    static class SimpleCacheEntry<V> {

        private V value;

        private long validate;

    }
}
