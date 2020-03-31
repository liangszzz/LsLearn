package threads.lock;

public class Stock {

    private int size = 5;

    public Stock() {
    }

    public Stock(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void decrease() {
        this.size--;
    }
}