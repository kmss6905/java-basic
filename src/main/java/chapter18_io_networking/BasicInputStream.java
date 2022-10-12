package chapter18_io_networking;

import java.io.FileInputStream;
import java.io.IOException;

public class BasicInputStream {

    public void inputStreamRead() throws IOException {
        FileInputStream is = new FileInputStream("/Users/minshik/Desktop/study/java-basic/src/main/resources/hello.txt");
        int readByte;
        long beforeTime = System.currentTimeMillis();
        while ((readByte = is.read()) != -1) {
            System.out.println("readByte : " + readByte);
        }
        is.close();
        long afterTime = System.currentTimeMillis();
        long diffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : " + diffTime);
    }

    public void inputStreamReadParam() throws IOException {
        FileInputStream is = new FileInputStream("/Users/minshik/Desktop/study/java-basic/src/main/resources/hello.txt");
        int readByte;
        byte[] b = new byte[100];
        long beforeTime = System.currentTimeMillis();
        while ((readByte = is.read(b)) != -1) {
            // return read count byte
            System.out.println("readByte : " + readByte);
        }
        is.close();
        long afterTime = System.currentTimeMillis();
        long diffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : " + diffTime);
    }
}
