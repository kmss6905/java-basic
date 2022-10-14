package chapter18_io_networking.file;

import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileClass {


    public static void main(String[] args) throws IOException {
        File dir = new File("/Users/minshik/Desktop/study/java-basic/src/main/resources/dir");
        File file1 = new File("/Users/minshik/Desktop/study/java-basic/src/main/resources/file1.txt");
        File file2 = new File("/Users/minshik/Desktop/study/java-basic/src/main/resources/file2.txt");
        File file3 = new File("/Users/minshik/Desktop/study/java-basic/src/main/resources/file3.txt");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        if (!file1.exists()) {
            file1.createNewFile();
        }

        if (!file2.exists()) {
            file2.createNewFile();
        }

        if (!file3.exists()) {
            file3.createNewFile();
        }
        System.out.println("날짜            시간        형태      크기    이름");
        System.out.println("-----------------------------------------------------");
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-dd-MM  a  hh:mm");
        File parentFile = dir.getParentFile();
        File[] contents = parentFile.listFiles();
        assert contents != null;
        for (File file : contents) {
            System.out.print(sdf.format(new Date(file.lastModified())));
            if (file.isDirectory()) {
                System.out.print("\t<DIR>\t\t\t" + file.length() + "\t" + file.getName());
            }else{
                System.out.print("\t\t\t\t\t" + file.length() + "\t" + file.getName());
            }
            System.out.println();
        }

    }
}
