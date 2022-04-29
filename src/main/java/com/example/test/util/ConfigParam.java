package com.example.test.util;

import org.springframework.beans.factory.annotation.Value;

public class ConfigParam {
        @Value("${file.upload.dir}")
        private String upLoadDirPath;

        public String getUpLoadDirPath() {
                return upLoadDirPath;
        }

        public void setUpLoadDirPath(String upLoadDirPath) {
                this.upLoadDirPath = upLoadDirPath;
        }
}
