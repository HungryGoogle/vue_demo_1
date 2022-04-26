package com.example.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @RequestMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }


    @Value("${file.upload.dir}")
    private String upLoadDirPath;

    /**
     * 第二种文件上传
     * 注意：这种方式适用于任何一种部署方式 推荐使用这种方式
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/uploadByJarDeploy")
    // 定义：接收文件对象 MultipartFile file变量名要与form表单中input type="file" 标签name属性名一致
    public String uploadByJarDeploy(MultipartFile file) throws IOException {

        // 文件名
        String originalFilename = file.getOriginalFilename();
        log.debug("文件名: {}", file.getOriginalFilename());
        log.debug("文件大小: {}", file.getSize());
        log.debug("文件类型: {}", file.getContentType());

        // 改文件名
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS-").format(new Date()) + UUID.randomUUID() + ext;

        // 上传文件到哪
        file.transferTo(new File(upLoadDirPath, newFileName));
        return "redirect:/";
    }


    @Value("${file.download.dir}")
    private String downloadRealPath;

    /**
     * 文件下载
     * @param fileName
     */
    @RequestMapping("/download")
    public void downloadFile(String fileName, HttpServletResponse response) throws Exception {
        log.debug("当前下载的文件名是：{}", fileName);
        log.debug("当前下载的文件的目录是：{}", downloadRealPath);
        // 1.去指定目录读取文件
        File file = new File(downloadRealPath, fileName);
        // 2.将文件读取为文件输入流
        FileInputStream is = new FileInputStream(file);
        // 2.1 获取响应流之前  一定要设置以附件形式下载
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        // 3.获取响应输出流
        ServletOutputStream os = response.getOutputStream();

        FileCopyUtils.copy(is,os);
    }

}