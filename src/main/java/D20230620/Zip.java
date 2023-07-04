package D20230620;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.*;

public class Zip {
    public static void main(String arg[]) throws Exception {
        extractZip("C:/Users/Administrator/Desktop/答辩记录表-数学1912赵晨懿.doc");
        //extractaZip("C:/Users/Administrator/Desktop/xuexicangku/src/D20230620/D20230620.zip");
    }

    public static String extractZip(String filePath) throws Exception {
        File file = new File(filePath);

        System.out.println(file.getName());
        String outputFileName = "C:/Users/Administrator/Desktop/答辩记录表-数学1912赵晨懿.doc" + file.getName() + ".zip";
        ArrayList<File> filelist = new ArrayList<>();

        if (file.isDirectory()) {
            filelist.addAll(Arrays.asList(file.listFiles()));
        } else {
            filelist.add(file);
        }
        FileInputStream fileInputStream = null;
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(new FileOutputStream(outputFileName), new Adler32());
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
        for (File f : filelist) {
            if (f.isDirectory()) {
                continue;
            }
            zipOutputStream.putNextEntry(new ZipEntry(f.getName()));
            fileInputStream = new FileInputStream(f);
            byte[] bytes = new byte[1024];
            int read;
            while ((read = fileInputStream.read(bytes)) != -1) {
                zipOutputStream.write(bytes);
            }
        }
        /*byte[] bytes = new byte[1024];
        int read;
        while ((read = fileInputStream.read(bytes)) != -1) {
            zipOutputStream.write(bytes);
        }*/
        fileInputStream.close();
        zipOutputStream.close();

        return outputFileName;
    }

    public static String extractaZip(String filePath) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        ZipEntry zipEntry;

        FileOutputStream fileOutputStream = null;
        File savePath = new File(filePath.replace(".zip", ""));
        if (!savePath.exists()) {
            savePath.mkdir();
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            fileOutputStream = new FileOutputStream("C:/Users/Administrator/Desktop/xuexicangku/src/D20230620/" + savePath.getName() + File.separator + zipEntry.getName());
            int x;
            byte[] bytes = new byte[1024];
            while ((x = bufferedInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes);
            }
            fileOutputStream.close();
        }
        zipInputStream.close();
        fileInputStream.close();
        return null;
    }
}