package jvmLearn.ConstantPool;

import java.util.List;

public class InvokeDynamicInfo extends AbstructPoolLoad {


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
        return "CONSTANT_InvokeDynamic_info";
    }

    @Override
    public byte getTag() {
        return 18;
    }


    /**
     * bootstrap_method_attrindex 值必须是对当前Class文件中引导方法表
     * 的bootstrap_methods[] 数组的有效索引
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
     * name_and_type_index 值必须是对但概念常量池的有效索引,常量池在该索引处的项必须
     * 是CONSTANT_NameAndType_info结构,表示方法名和方法描述符
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
