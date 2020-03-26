package design.adapter;

public class Adapter2 {

    public static void main(String[] args) {

        MacAdapter adapter = new MacAdapter(new Output220());
        System.out.println(adapter.output20());

    }

    static class Output220 {

        public int output() {
            return 220;
        }

    }

    static interface Output {

        int output5();

        int output12();

        int output20();
    }

    static abstract class DefaultAdapter implements Output {

        @Override
        public int output5() {
            return 0;
        }

        @Override
        public int output12() {
            return 0;
        }

        @Override
        public int output20() {
            return 0;
        }
    }

    static class MacAdapter extends DefaultAdapter {

        private Output220 output220;

        MacAdapter(Output220 output220) {
            this.output220 = output220;
        }

        @Override
        public int output20() {
            return output220.output() / 11;
        }
    }

}
