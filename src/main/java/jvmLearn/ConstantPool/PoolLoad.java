package jvmLearn.ConstantPool;

import jvmLearn.Clazz.ConstantPool;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface PoolLoad {

    void execute(List<Byte> bytes, AtomicInteger index, List<ConstantPool> constantPools);

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

    void executeNext(List<Byte> bytes, AtomicInteger index, List<ConstantPool> constantPools);
}
