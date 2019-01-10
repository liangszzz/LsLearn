package jvmLearn;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadClass {

    public void read() throws IOException {

        String clazzpath = "D:\\github\\LsLearn\\target\\classes\\jvmLearn\\ClassType.class";
        try (
                FileInputStream inputStream = new FileInputStream(new File(clazzpath))) {
            byte[] bytes = new byte[16];
            while (true) {
                int len = inputStream.read(bytes);
                if (len == -1) {
                    break;
                }
                for (byte b : bytes) {
//                    String str = Integer.toHexString(Byte.toUnsignedInt(b)).toUpperCase();
                    System.out.print(b);
                    System.out.print(" ");
                }
                System.out.println("");
            }
        }


    }

    @Test
    public void readClass() throws IOException {
        String clazzpath = "D:\\github\\LsLearn\\target\\classes\\jvmLearn\\ClassType.class";
        List<Byte> bytes = new ArrayList<>(1024);
        LoadClazz(clazzpath, bytes);
        if (bytes.size() < 4) {
            System.out.println("#class is error");
            return;
        }

        if (!checkClass(bytes)) {
            System.out.println("#class can't load for jvm");
            return;
        }
        showClassVersion(bytes);
        loadConstantPool(bytes, null);

    }

    public void LoadClazz(String filepath, List<Byte> byteList) throws IOException {
        try (
                FileInputStream inputStream = new FileInputStream(new File(filepath))) {
            byte[] bytes = new byte[16];
            while (true) {
                int len = inputStream.read(bytes);
                if (len == -1) {
                    break;
                }
                for (byte b : bytes) {
                    byteList.add(b);
                }
            }
        }
    }

    /**
     * 检查文件头 是否是class文件
     *
     * @param bytes 4
     * @return
     */
    public boolean checkClass(List<Byte> bytes) {
        if (bytes == null || bytes.size() < 4) {
            return false;
        }
        if (bytes.get(0) == -54 && bytes.get(1) == -02 && bytes.get(2) == -70 && bytes.get(3) == -66) {
            return true;
        }
        return false;
    }

    int[] jdks = new int[]{
            51
    };

    /**
     * 检查文件支持的JDK版本
     *
     * @param bytes 4
     */
    public void showClassVersion(List<Byte> bytes) {

        if (bytes == null || bytes.size() <= 8) {
            System.out.println("#");
        }
        String minor_version = bytes.get(4) + "" + bytes.get(5);
        System.out.println("minor_version:" + minor_version);
        String major_version = bytes.get(6) + "" + bytes.get(7);
        System.out.println("major_version:" + major_version);
    }

    /**
     * 处理常量池
     *
     * @param bytes
     */
    public void loadConstantPool(List<Byte> bytes, Map<String, String> map) {
        //获取常量池里的常量数量
        byte a = bytes.get(8);
        byte b = bytes.get(9);
        int really_count = getU2(a, b);
        //常量池的索引是从1开始的
        really_count -= 1;
        System.out.println(really_count);

        //字面常量和符号常量
        for (int i = 10, count = 0; count <= really_count + 10; count++) {
            byte aByte1 = bytes.get(i);
            byte aByte2 = bytes.get(++i);
            byte aByte3 = bytes.get(++i);
            byte aByte4 = bytes.get(++i);
            byte aByte5 = bytes.get(++i);
            i++;
            System.out.println(aByte1 + "#" + aByte2 + "#" + aByte3 + "#" + aByte4 + "#" + aByte5);
        }
    }

    /**
     * 获取U2 数 转换成 int
     *
     * @param a
     * @param b
     * @return
     */
    public int getU2(byte a, byte b) {
        int really = a;
        if (a > 0) {
            String str = Integer.toHexString(a) + "00";
            really = Integer.valueOf(str, 16);
        }
        return really + b;
    }
}
