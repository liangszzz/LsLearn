package jvmLearn.ConstantPool;

import java.util.List;

public class ClassInfo extends AbstructPoolLoad {


    @Override
    public boolean checkSupport(byte b) {
        if (b == getTag()) {
            return true;
        }
        return false;
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public String getConstantName() {
        return "CONSTANT_Class_info";
    }

    @Override
    public byte getTag() {
        return 7;
    }


    /**
     * index 指向字符串字面量的索引
     *
     * @return
     */
    @Override
    public byte[] getLength(List<Byte> list, int start) {
        byte[] bs = new byte[4];
        bs[0] = list.get(start + 1);
        bs[1] = list.get(start + 2);
        return bs;
    }

    /**
     * NULL
     *
     * @return
     */
    @Override
    public byte[] getBytes(List<Byte> list, int start) {

        return null;
    }
}
