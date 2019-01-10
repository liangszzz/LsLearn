package jvmLearn.ConstantPool;

import java.util.List;

public class MethodTypeInfo extends AbstructPoolLoad {


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
        return "CONSTANT_MethodHandle_info";
    }

    @Override
    public byte getTag() {
        return 16;
    }


    /**
     * description 值必须是对常量池的有效索引,常量池在该索引处的项必须是CONSTANT_Utf8_info结构,
     * 表示方法的描述符
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
