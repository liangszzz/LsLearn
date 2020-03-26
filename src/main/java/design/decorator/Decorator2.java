package design.decorator;

public class Decorator2 {

    public static void main(String[] args) {

        Drink coffee = new Coffee();
        System.out.println(coffee.price());

        Drink milk = new Milk(coffee);
        System.out.println(milk.price());

        Drink sugar = new Sugar(milk);
        System.out.println(sugar.price());

    }

    static interface Drink {

        int price();
    }

    static class Coffee implements Drink {

        @Override
        public int price() {
            return 20;
        }
    }

    static abstract class Deco implements Drink {

        private Drink drink;

        protected Deco(Drink drink) {
            this.drink = drink;
        }

        @Override
        public int price() {
            return drink.price();
        }
    }

    static class Milk extends Deco {

        protected Milk(Drink drink) {
            super(drink);
        }

        @Override
        public int price() {
            return super.price() + 10;
        }
    }

    static class Sugar extends Deco {

        protected Sugar(Drink drink) {
            super(drink);
        }

        @Override
        public int price() {
            return super.price() + 10;
        }
    }

}
