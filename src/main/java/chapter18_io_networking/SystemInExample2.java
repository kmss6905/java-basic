package chapter18_io_networking;

import java.io.IOException;
import java.io.InputStream;

public class SystemInExample2 {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        byte[] datas = new byte[100];
        System.out.println("이름 : ");
        int nameBytes = is.read(datas);
        String name = new String(datas, 0, nameBytes - 2);

        System.out.println("입력한 이름 : " + name);
    }
}
