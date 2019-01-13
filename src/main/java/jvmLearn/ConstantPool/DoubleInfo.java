package jvmLearn.ConstantPool;

import java.util.List;

public class DoubleInfo extends AbstructPoolLoad {


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
        return "CONSTANT_Double_info";
    }

    @Override
    public byte getTag() {
        return 6;
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
     * bytes 按照高位在前存储的Double值
     *
     * @return
     */
    @Override
    public byte[] getBytes(List<Byte> list, int start) {
        byte[] bs = new byte[8];
        for (int i = 0; i < 8; i++) {
            bs[i] = list.get(start + 1 + i);
        }
        return bs;
    }
}
