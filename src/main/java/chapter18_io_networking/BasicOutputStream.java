package chapter18_io_networking;

import java.io.*;
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
        os.flush();
        os.close();
    }

    public static void main(String[] args) throws IOException {


    }

    private static void consoleIn() throws IOException {
        InputStream is = System.in;
        char a = (char)is.read();
        if (a == 'A') {
            System.out.printf("%S 가 입력되었습니다.", a);
        }
    }

    private static void fileReaderWithCharArray() throws IOException {
        FileReader r = new FileReader("/Users/minshik/Desktop/study/java-basic/src/main/resources/hello.txt");
        int read;
        char[] cbuf = new char[1000];
        while ((read = r.read(cbuf)) != -1) {
            System.out.println(read);
        }
        r.close();
    }

    private static void fileReader() throws IOException {
        FileReader r = new FileReader("/Users/minshik/Desktop/study/java-basic/src/main/resources/hello.txt");
        int readDate;
        while ((readDate = r.read()) != -1) {
            char charData = (char) readDate;
            System.out.println(charData);
        }
    }
}
