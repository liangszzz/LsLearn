package design.strategy;

public class Strategy {

    public static void main(String[] args) {

        Context context = new Context(new S2());
        System.out.println(context.exec());

    }
}

interface S {


    int operation();
}

class S1 implements S {

    @Override
    public int operation() {
        return 1;
    }
}


class S2 implements S {

    @Override
    public int operation() {
        return 2;
    }
}

class S3 implements S {

    @Override
    public int operation() {
        return 3;
    }
}

class Context {

    private final S s;


    Context(S s) {
        this.s = s;
    }

    public int exec() {
        return s.operation();
    }
}