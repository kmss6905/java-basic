package chapter18_io_networking.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerExample {

    /**
     * 서버 소켓 생성 create
     * bind
     * accept 이후 연결 된  connection(socket) 으로 데이터 받아 들이기
     * socket 을 데이터 전송하기
     *
     */

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // create
            serverSocket = new ServerSocket();

            // bind
            serverSocket.bind(new InetSocketAddress("localhost", 5001));

            // accept,  blocking
            System.out.println("[서버 소켓 생성]");
            Socket socket = serverSocket.accept();

            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[100];
            int byteReadCount = is.read(bytes);
            String s = new String(bytes, 0, byteReadCount);
            System.out.println("[클라이언트로 부터 데이터 받음] : " + s);


            //  클라이언트로 데이터 전송
            OutputStream os = socket.getOutputStream();
            byte[] message = "hello client".getBytes(StandardCharsets.UTF_8);
            os.write(message);
            os.flush();

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
