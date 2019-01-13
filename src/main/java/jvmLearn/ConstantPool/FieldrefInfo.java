package jvmLearn.ConstantPool;

import java.util.List;

public class FieldrefInfo extends AbstructPoolLoad {


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
        return "CONSTANT_Fieldref_info";
    }

    @Override
    public byte getTag() {
        return 9;
    }


    /**
     * index 指向声明字段的类或者接口描述符CONSTANT_Class_info
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
     * index 指向声明字段的类或者接口描述符CONSTANT_NameAndType_info
     *
     * @return
     */
    @Override
    public byte[] getBytes(List<Byte> list, int start) {
        byte[] bs = new byte[2];
        bs[0] = list.get(start + 3);
        bs[1] = list.get(start + 4);
        return bs;
    }
}
