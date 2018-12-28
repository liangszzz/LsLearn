package design.chain;

public interface Handle {

    Handle getNext();

    void setNext(Handle handle);

    void execute(int level);
}
