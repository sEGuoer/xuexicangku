package D20230619;

import java.io.File;
import java.io.IOException;

public class Text {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:/Users/Administrator/Desktop/xuexicangku/src/D20230619/test1");
        System.out.println(file1.getParent());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        boolean newjavaFlie = file1.mkdir();
        System.out.println(newjavaFlie);
        File file2 = new File("C:/Users/Administrator/Desktop/xuexicangku/src/D20230619/test1.txt");
        boolean newFile = file2.createNewFile();
        System.out.println(newFile);

    }
}
