package com.example.test.util;

import com.example.test.controller.HelloController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
    public static void info(String args){
        logger.info(args);
    }
}
