package chapter18_io_networking.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) throws IOException {
        String originalFileName = "/Users/minshik/Desktop/study/java-basic/src/main/resources/sample.png";
        String targetFileName = "/Users/minshik/Desktop/study/java-basic/src/main/resources/sample_copy.jpg";


        FileInputStream fis = new FileInputStream(originalFileName);
        try (FileOutputStream fos = new FileOutputStream(targetFileName)) {

            int cnt;
            byte[] bytes = new byte[100];
            while ((cnt = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, cnt);
            }

            fos.flush();
            fos.close();
        }
        fis.close();

        System.out.println("복사가 잘 되었습니다.");
    }
}
