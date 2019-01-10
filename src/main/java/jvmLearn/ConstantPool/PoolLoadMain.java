package jvmLearn.ConstantPool;

import java.util.List;

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
                    .setNext(floatInfo).setNext(doubleInfo).setNext(classInfo)
                    .setNext(stringInfo).setNext(fieldrefInfo).setNext(methodrefInfo)
                    .setNext(interfaceMethodrefInfo).setNext(nameAndTypeInfo)
                    .setNext(methodHandleInfo).setNext(methodTypeInfo).setNext(invokeDynamicInfo);

        }
    }


    public int execute(List<Byte> list, int start) {
        int execute = poolLoad.execute(list, start);
        return execute;
    }


}
