package com.example.test.util.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "dishmenu")
public class DishConfig {
    int maxDishItem;
    private String fileUploadDir;
    private String fileDownloadDir;
    private String fileUploadToken;

    public int getMaxDishItem() {
        return maxDishItem;
    }

    public void setMaxDishItem(int maxDishItem) {
        this.maxDishItem = maxDishItem;
    }

    public String getFileUploadDir() {
        return fileUploadDir;
    }

    public void setFileUploadDir(String fileUploadDir) {
        this.fileUploadDir = fileUploadDir;
    }

    public String getFileDownloadDir() {
        return fileDownloadDir;
    }

    public void setFileDownloadDir(String fileDownloadDir) {
        this.fileDownloadDir = fileDownloadDir;
    }

    public String getFileUploadToken() {
        return fileUploadToken;
    }

    public void setFileUploadToken(String fileUploadToken) {
        this.fileUploadToken = fileUploadToken;
    }
}
