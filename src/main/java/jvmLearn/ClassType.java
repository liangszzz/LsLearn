package jvmLearn;

import lombok.Data;

@Data
public class ClassType {

    private final int int_num = 12;
    private final char char_num = 'a';
    private final short short_num = 30;
    private final float float_num = 45.3f;
    private final double double_num = 39.8;
    private final byte byte_num = 121;
    private final long long_num = 2323L;
    private final boolean boolean_flage = true;


    private int int_num1 = 12;
    private char char_num1 = 'a';
    private short short_num1 = 30;
    private float float_num1 = 45.3f;
    private double double_num1 = 39.8;
    private byte byte_num1 = 121;
    private long long_num1 = 2323L;
    private long long_delay_num1;
    private boolean boolean_flage1 = true;


    public static void main(String[] args) {
        System.out.println("##");
    }

}
