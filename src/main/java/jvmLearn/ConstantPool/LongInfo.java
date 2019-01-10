package jvmLearn.ConstantPool;

import java.util.List;

public class LongInfo extends AbstructPoolLoad {


    @Override
    public boolean checkSupport(byte b) {
        if (b == getTag()) {
            return true;
        }
        return false;
    }

    @Override
    public int getCount() {
        return 9;
    }


    @Override
    public String getConstantName() {
        return "CONSTANT_Long_info";
    }

    @Override
    public byte getTag() {
        return 5;
    }


    /**
     * NULL
     *
     * @return
     */
    @Override
    public byte[] getLength(List<Byte> list, int start) {
        return null;
    }

    /**
     * bytes 按照高位在前存储的Float值
     *
     * @return
     */
    @Override
    public byte[] getBytes(List<Byte> list, int start) {
        byte[] bs = new byte[4];
        bs[0] = list.get(start + 1);
        bs[1] = list.get(start + 2);
        bs[2] = list.get(start + 3);
        bs[3] = list.get(start + 4);
        return bs;
    }
}
