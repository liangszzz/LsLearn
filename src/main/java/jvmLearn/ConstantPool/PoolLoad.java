package jvmLearn.ConstantPool;

import java.util.List;

public interface PoolLoad {

    int execute(List<Byte> list, int start);

    /**
     * 支持的常量
     *
     * @return
     */
    boolean checkSupport(byte b);

    int getCount();

    /**
     * 常量名称
     *
     * @return
     */
    String getConstantName();

    /**
     * 获取Tag
     *
     * @return
     */
    byte getTag();


    byte[] getLength(List<Byte> list, int start);


    byte[] getBytes(List<Byte> list, int start);

    /**
     * 下一个
     *
     * @param poolLoad
     * @return
     */
    PoolLoad setNext(PoolLoad poolLoad);

    int executeNext(List<Byte> list, int start);
}
