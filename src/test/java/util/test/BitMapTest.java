package util.test;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

public class BitMapTest {


    @Test
    public void test0() {

        BitSet bitSet = new BitSet(20);


        bitSet.set(0, 5);
        bitSet.set(8, 9);


        System.out.println(bitSet.nextClearBit(0));

        System.out.println(bitSet.get(5));

        System.out.println(bitSet.previousClearBit(8));
    }
}
