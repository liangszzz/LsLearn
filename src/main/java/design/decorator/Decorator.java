package design.decorator;

import lombok.Getter;
import lombok.Setter;

public class Decorator {

    public static void main(String[] args) {
        de0 d0 = new de0();
        d0.say();

        de1 d1 = new de1(d0);
        d1.say();

    }


    static abstract class de {

        public abstract void say();

    }

    static class de0 extends de {

        @Getter
        @Setter
        private int a;

        @Override
        public void say() {
            System.out.println("##############" + getA());
        }
    }

    static class de1 extends de {

        private de0 d;

        public de1(de0 d) {
            this.d = d;
        }

        @Override
        public void say() {
            System.out.println(d.getA() + 2);
        }
    }

}
