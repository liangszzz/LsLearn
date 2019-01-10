package jvmLearn.ConstantPool;

import java.util.List;

public class MethodHandleInfo extends AbstructPoolLoad {


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
        return "CONSTANT_MethodHandle_info";
    }

    @Override
    public byte getTag() {
        return 15;
    }


    /**
     * reference_kind 值必须在[1-9]之间,它决定了方法句柄的类型,方法句柄类型的值
     * 表示方法句柄的字节码行为
     *
     * @return
     */
    @Override
    public byte[] getLength(List<Byte> list, int start) {
        byte[] bs = new byte[4];
        bs[0] = list.get(start + 1);
        return bs;
    }

    /**
     * reference_index 值必须是对常量池的有效索引
     *
     * @return
     */
    @Override
    public byte[] getBytes(List<Byte> list, int start) {
        byte[] bs = new byte[4];
        bs[0] = list.get(start + 2);
        bs[1] = list.get(start + 3);
        return bs;
    }
}
