package com.example.test.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @program: world
 * @description: doc工具类
 * @author: XinHai.Ma
 * @create: 2021-09-09 15:54
 */
public class DocUtils {

    public static void saveWord(String filePath, Map<String,Object> dataMap) throws IOException {
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(DocUtils.class, "/");
//        Template template = configuration.getTemplate("templates/template.xml");
        Template template = configuration.getTemplate("templates/doc/专家评审费邀请函.xml");
        InputStreamSource streamSource = createWord(template, dataMap);
        InputStream inputStream = streamSource.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(filePath);
        byte[] bytes = new byte[1024];
        while ((inputStream.read(bytes)) != -1) {
            outputStream.write(bytes);// 写入数据
        }
        inputStream.close();
        outputStream.close();
    }

    public static InputStreamSource createWord(Template template, Map<String, Object> dataMap) {
        StringWriter out = null;
        Writer writer = null;
        try {
            out = new StringWriter();
            writer = new BufferedWriter(out, 1024);
            template.process(dataMap, writer);
            return new ByteArrayResource(out.toString().getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}