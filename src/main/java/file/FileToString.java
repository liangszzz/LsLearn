package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class FileToString {

    public static String fileToString(String path) throws IOException {

        byte[] bytes = Files.readAllBytes(Paths.get(path));

        return Base64.getEncoder().encodeToString(bytes);

    }

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\liang\\Desktop\\t1.xlsx";
        System.out.println(fileToString(path));
    }
}
