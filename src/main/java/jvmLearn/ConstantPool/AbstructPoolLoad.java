package jvmLearn.ConstantPool;

import java.util.Arrays;
import java.util.List;

public abstract class AbstructPoolLoad implements PoolLoad {


    protected PoolLoad nextPoolLoad;


    @Override
    public PoolLoad setNext(PoolLoad poolLoad) {
        this.nextPoolLoad = poolLoad;
        return poolLoad;
    }

    @Override
    public int execute(List<Byte> list, int start) {
        byte type = list.get(start);
        if (!checkSupport(type)) {
            return executeNext(list, start);
        }

        System.out.println(getConstantName() + "  start");
        byte[] index1 = getLength(list, start);
        System.out.println(Arrays.toString(index1));
        byte[] index2 = getBytes(list, start);
        System.out.println(Arrays.toString(index2));
        System.out.println(getConstantName() + "  end");


        return start + getCount();
    }

    @Override
    public int executeNext(List<Byte> list, int start) {
        if (nextPoolLoad != null)
            return nextPoolLoad.execute(list, start);
        return 0;
    }

}
