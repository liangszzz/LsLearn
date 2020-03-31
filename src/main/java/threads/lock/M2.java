package threads.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class M2 {

    private static Unsafe unsafe;

    private int state;

    private static long offset;

    static {

        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            offset = unsafe.objectFieldOffset(M2.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void t1() {
        System.out.println(state);
        System.out.println("" + unsafe.compareAndSwapInt(this, offset, 0, 1));
        System.out.println(state);
    }

    public static void main(String[] args) {

        M2 m = new M2();

        m.t1();

    }

}
