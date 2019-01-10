package jvmLearn.ConstantPool;

import java.util.List;

public class NameAndTypeInfo extends AbstructPoolLoad {


    @Override
    public boolean checkSupport(byte b) {
        if (b == getTag()) {
            return true;
        }
        return false;
    }

    @Override
    public int getCount() {
        return 5;
    }


    @Override
    public String getConstantName() {
        return "CONSTANT_NameAndTypeInfo_info";
    }

    @Override
    public byte getTag() {
        return 12;
    }


    /**
     * index 指向该字段或方法名称常量项的索引
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
     * index 指向该字段或方法描述符常量项的索引
     *
     * @return
     */
    @Override
    public byte[] getBytes(List<Byte> list, int start) {
        byte[] bs = new byte[4];
        bs[0] = list.get(start + 3);
        bs[1] = list.get(start + 4);
        return bs;
    }
}
