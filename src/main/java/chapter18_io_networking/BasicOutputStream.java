package chapter18_io_networking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BasicOutputStream {

    public void fileOutputStream() throws IOException {
        FileOutputStream os = new FileOutputStream("/Users/minshik/Desktop/study/java-basic/src/main/resources/hello.txt");
        byte[] data = "ABCDABCDABCDABCDABCD".getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < data.length; i++) {
            System.out.println("data[" + i + "] = " + data[i]);
            os.write(data[i]);
        }
        os.close();
     }

    public void fileOutputStreamParam() throws IOException{
        FileOutputStream os = new FileOutputStream("/Users/minshik/Desktop/study/java-basic/src/main/resources/hello.txt");
        byte[] data = "ABCDABCDABCDABCDABCD".getBytes(StandardCharsets.UTF_8);
        os.write(data);
        os.close();
    }

    public static void main(String[] args) throws IOException {
        BasicOutputStream stream = new BasicOutputStream();
        stream.fileOutputStreamParam();
    }
}
