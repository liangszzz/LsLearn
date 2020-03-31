package threads.product;

import java.util.ArrayList;
import java.util.List;

public class Pool {

    private List<String> list;

    private int size;

    public Pool(int size) {
        list = new ArrayList<>();
        this.size = size;
    }

    public synchronized void product() throws InterruptedException {
        if (list.size() < size) {
            String str = Math.random() + "产品";
            System.out.println("生产  "+str);
            list.add(str);
            this.notifyAll();
        } else {
            this.wait();
        }
    }

    public synchronized String consumer() throws InterruptedException {
        if (list.size() == 0) {
            this.wait();
        }
        String remove = list.remove(0);
        this.notifyAll();
        return remove;
    }
}
