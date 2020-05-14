package cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleCache implements Cache<String, String> {

    private final int max;

    Map<String, String> map;


    public SimpleCache(int max) {
        this.max = max;
        this.map = new ConcurrentHashMap<>(max);
    }

    @Override
    public boolean put(String key, String value) {
        return checkSize() && map.put(key, value) != null;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public int remove(String key) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void invalidate(String key) {

    }

    private boolean checkSize() {
        return this.map.size() < this.max;
    }
}
