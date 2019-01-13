package jvmLearn.ConstantPool;

import jvmLearn.Clazz.ConstantPool;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PoolLoadMain {

    private static PoolLoad poolLoad;

    static {
        init();
    }

    private static synchronized void init() {
        if (poolLoad == null) {
            poolLoad = new Utf8Info();

            IntegerInfo integerInfo = new IntegerInfo();
            FloatInfo floatInfo = new FloatInfo();
            LongInfo longInfo = new LongInfo();
            DoubleInfo doubleInfo = new DoubleInfo();
            ClassInfo classInfo = new ClassInfo();
            StringInfo stringInfo = new StringInfo();
            FieldrefInfo fieldrefInfo = new FieldrefInfo();
            MethodrefInfo methodrefInfo = new MethodrefInfo();
            InterfaceMethodrefInfo interfaceMethodrefInfo = new InterfaceMethodrefInfo();
            NameAndTypeInfo nameAndTypeInfo = new NameAndTypeInfo();
            MethodHandleInfo methodHandleInfo = new MethodHandleInfo();
            MethodTypeInfo methodTypeInfo = new MethodTypeInfo();
            InvokeDynamicInfo invokeDynamicInfo = new InvokeDynamicInfo();

            poolLoad.setNext(integerInfo).setNext(floatInfo).setNext(longInfo)
                    .setNext(doubleInfo).setNext(classInfo).setNext(stringInfo)
                    .setNext(fieldrefInfo).setNext(methodrefInfo)
                    .setNext(interfaceMethodrefInfo).setNext(nameAndTypeInfo)
                    .setNext(methodHandleInfo).setNext(methodTypeInfo)
                    .setNext(invokeDynamicInfo);

        }
    }


    public void execute(List<Byte> bytes, AtomicInteger integer, List<ConstantPool> list) {
        poolLoad.execute(bytes, integer, list);
    }
}
