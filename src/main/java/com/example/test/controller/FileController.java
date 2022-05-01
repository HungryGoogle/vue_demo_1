package com.example.test.controller;

import com.alibaba.excel.EasyExcel;
import com.example.test.bean.DishBean;
import com.example.test.bean.KeyValueBean;
import com.example.test.service.DishService;
import com.example.test.serviceImpl.DishMenuExcelListener;
import com.example.test.serviceImpl.KeyValueExcelListener;
import com.example.test.util.LogUtil;
import com.example.test.util.config.DishConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    DishConfig dishConfig;

    @Autowired
    DishService dishService;

    @RequestMapping("/toUpload")
    public String toUpload(Model modelMap) {
        LogUtil.info("toUpload ...");
        modelMap.addAttribute("uploadResult", "请先下载模板，根据模板完善信息后上传...");
        return "upload";
    }

    /**
     * 第二种文件上传
     * 注意：这种方式适用于任何一种部署方式 推荐使用这种方式
     *
     * @param file
     * @throws IOException
     */
    @RequestMapping("/uploadByJarDeploy")
    public String uploadByJarDeploy( KeyValueBean keyValueBean, MultipartFile file,Model modelMap) throws IOException {
        String originalFilename = file.getOriginalFilename();
        LogUtil.info("文件名: " + dishConfig.getFileUploadDir() + file.getOriginalFilename());
        String newFileName = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS-").format(new Date()) + originalFilename;

        try {
            file.transferTo(new File(dishConfig.getFileUploadDir(), newFileName));
        } catch (Exception e) {
            log.error("uploadfile error {}", e.getMessage());
            modelMap.addAttribute("uploadResult", "文件上传失败，请重试...");
            return "upload";
        }

        // 下载之后，进行解析1，token是否正确
        try {
            DishMenuManager.getIns().init(dishService, dishConfig);
            EasyExcel.read(dishConfig.getFileUploadDir() + newFileName, KeyValueBean.class, new KeyValueExcelListener()).sheet("token").doRead();
            EasyExcel.read(dishConfig.getFileUploadDir() + newFileName, DishBean.class, new DishMenuExcelListener()).sheet("周菜单").doRead();
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("uploadResult", "文件解析失败，请重试...");
            return "upload";
        }

        modelMap.addAttribute("uploadResult", "已上传文件成功");
        return "redirect:/weekDishes";
    }


    /**
     * 文件下载
     */
    @RequestMapping("/download")
    public void downloadFile(String fileName, HttpServletResponse response) throws Exception {
        LogUtil.info("当前下载的文件的目录是：" + dishConfig.getFileDownloadDir());
        File file = new File(dishConfig.getFileDownloadDir(), fileName);
        FileInputStream is = new FileInputStream(file);
        // 2.1 获取响应流之前  一定要设置以附件形式下载
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        // 3.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        FileCopyUtils.copy(is, os);
    }


}