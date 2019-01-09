package jvmLearn;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadClass {

    @Test
    public void read() throws IOException {

        try (
                FileInputStream inputStream = new FileInputStream(new File("D:\\github\\LsLearn\\target\\classes\\book1\\book4_3_1.class"))) {
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
        String clazzpath = "D:\\github\\LsLearn\\target\\classes\\book1\\book4_3_1.class";
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
    public void constant_pool(List<Byte> bytes, Map<String, String> map) {

    }
}
