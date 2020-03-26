package design.adapter;

public class Adapter {

    public static void main(String[] args) {

        IOAdapter adapter = new IOAdapter();
        System.out.println(adapter.output());
        System.out.println(adapter.output5());
    }


    /**
     * 交流电 220v
     */
    static class Output {

        public int output() {
            return 220;
        }

    }

    /**
     * 要求 5v
     */
    static interface Target {

        int output5();
    }

    static class IOAdapter extends Output implements Target {

        @Override
        public int output5() {
            return output() / 44;
        }
    }
}
