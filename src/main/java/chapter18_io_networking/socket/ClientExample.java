package chapter18_io_networking.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientExample {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket();
            System.out.println("[연결 요청]");
            socket.connect(new InetSocketAddress("localhost", 5001));
            System.out.println("[연결 성공]");
            OutputStream os = socket.getOutputStream();

            byte[] bytes = null;
            String message = null;

            message = "hello server";
            bytes = message.getBytes(StandardCharsets.UTF_8);
            os.write(bytes);
            os.flush();
            System.out.println("[데이터 전송 성공]");


            InputStream is = socket.getInputStream();
            bytes = new byte[100];
            int readByteCount = is.read(bytes);
            String serverMessage = new String(bytes, 0, readByteCount, StandardCharsets.UTF_8);
            System.out.println("[데이터 받기 성공]: " + serverMessage);

            // 상대방이 정상적으로 Socker의 close() 를 호출했을 경우
            if (readByteCount == -1) {
                throw new IOException();
            }

            os.close();
            is.close();
        } catch (Exception e) {

        }

        if (!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
