package chapter18_io_networking;

import java.io.IOException;
import java.io.InputStream;

public class SystemInExample1 {
    public static void main(String[] args) throws IOException {
        System.out.println("== 메뉴 ==");
        System.out.println("1. 예금 조회");
        System.out.println("2. 예금 출금");
        System.out.println("3. 예금 입금");
        System.out.println("3. 종료하기");
        System.out.println("메뉴를 선택하세요: ");

        InputStream in = System.in; // 키코드 입력 스트림 얻음
        char read = (char) in.read();
        switch (read) {
            case '1':
                System.out.println("예금 조회를 선택하셨습니다.");
                break;
            case '2':
            default:
                System.out.println("예금 출금을 선택하셨습니다.");
        }
    }
}
