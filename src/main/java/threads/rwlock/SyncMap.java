package threads.rwlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SyncMap {

    private Map<String, String> map;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public SyncMap() {
        this.map = new HashMap<>(16);
    }


    public static void main(String[] args) {


    }

    static class PutRunnable implements Runnable {

        private SyncMap map;

        PutRunnable(SyncMap map) {
            this.map = map;
        }

        @Override
        public void run() {


        }
    }


    public void put(String key, String value) {
        lock.writeLock().lock();
        try {
            map.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String get(String key) {
        lock.readLock().lock();
        try {
            return map.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }


}
