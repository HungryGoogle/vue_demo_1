package com.example.test.controller;

public class StringUtils {
    public static boolean isEmpty(String in) {
        return in == null || in.equalsIgnoreCase("");
    }
}
