package jvmLearn.ConstantPool;

import java.util.List;

public class Utf8Info extends AbstructPoolLoad {


    @Override
    public boolean checkSupport(byte b) {
        if (b == getTag()) {
            return true;
        }
        return false;
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public String getConstantName() {
        return "CONSTANT_Utf8_info";
    }

    @Override
    public byte getTag() {
        return 1;
    }


    /**
     * length UTF-8编码的字符串占用的字节数
     *
     * @return
     */
    @Override
    public byte[] getLength(List<Byte> list, int start) {
        byte[] bs = new byte[2];
        bs[0] = list.get(start + 1);
        bs[1] = list.get(start + 2);
        return bs;
    }

    /**
     * bytes 长度为length的UTF-8编码的字符串
     *
     * @return
     */
    @Override
    public byte[] getBytes(List<Byte> list, int start) {
        byte[] bs = new byte[1];
        bs[0] = list.get(start + 3);
        return bs;
    }
}
