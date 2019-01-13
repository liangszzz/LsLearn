package jvmLearn.ConstantPool;

import jvmLearn.Clazz.ConstantPool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstructPoolLoad implements PoolLoad {


    protected PoolLoad nextPoolLoad;

    protected int length;


    @Override
    public PoolLoad setNext(PoolLoad poolLoad) {
        this.nextPoolLoad = poolLoad;
        return poolLoad;
    }

    @Override
    public void execute(List<Byte> bytes, AtomicInteger index, List<ConstantPool> constantPools) {

        byte type = bytes.get(index.get());
        if (!checkSupport(type)) {
            executeNext(bytes, index, constantPools);
            return;
        }
        System.out.println(getConstantName() + "  start");
        byte[] length = getLength(bytes, index.get());
        setLength(length);
        System.out.println(Arrays.toString(length));
        byte[] bytes_info = getBytes(bytes, index.getAndAdd(getCount()));
        System.out.println(Arrays.toString(bytes_info));

        ConstantPool constantPool = new ConstantPool();
        constantPool.setLength(length);
        constantPool.setBytes(bytes_info);
        constantPools.add(constantPool);

        System.out.println(getConstantName() + "  end");

    }

    @Override
    public void executeNext(List<Byte> bytes, AtomicInteger index, List<ConstantPool> constantPools) {
        if (nextPoolLoad != null)
            nextPoolLoad.execute(bytes, index, constantPools);
    }

    /**
     * 获取U2 数 转换成 int
     *
     * @return
     */
    protected void setLength(byte[] bytes) {
        if (bytes == null || bytes.length != 2) {
            return;
        }
        byte a = bytes[0], b = bytes[1];
        if (a > 0) {
            String str = Integer.toHexString(a) + "00";
            length = Integer.valueOf(str, 16) + a;
        } else {
            length = b;
        }
    }
}
