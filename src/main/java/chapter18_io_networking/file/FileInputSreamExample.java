package chapter18_io_networking.file;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputSreamExample {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("/Users/minshik/Desktop/study/java-basic/src/main/resources/hello.txt");
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char)data);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
