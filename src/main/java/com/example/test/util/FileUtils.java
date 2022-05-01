package com.example.test.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static void copyFileNew(String srcFileName,String dstFileName){
        //源文件
        File file = new File(srcFileName);
        Path path = file.toPath();
        try {
            //创建目录
            File db = new File(dstFileName);
            if (!db.exists()) {
                db.getParentFile().mkdirs();
            }
            long result = Files.copy (path,new FileOutputStream(db));
            LogUtil.info("file copy result = " + result);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static void copyFileUsingStream(String source, String dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
