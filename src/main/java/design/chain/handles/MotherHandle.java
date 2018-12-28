package design.chain.handles;

import design.chain.Handle;

public class MotherHandle implements Handle {

    private Handle next;

    private final int LEVEL = 1;

    @Override
    public Handle getNext() {
        return next;
    }

    @Override
    public void setNext(Handle handle) {
        next = handle;
    }

    @Override
    public void execute(int level) {

        if (level == LEVEL) {
            System.out.println("#monther deal this thing");
        } else {
            System.out.println("#mother can't deal,give it to next");
            if (getNext() != null)
                getNext().execute(level);
        }

    }
}
