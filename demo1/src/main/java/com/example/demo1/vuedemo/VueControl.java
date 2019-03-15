package com.example.demo1.vuedemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class VueControl {
    @GetMapping("/vuedemo")
    public String user(){
        System.out.println("vue demo");
        return "index";
    }

    @GetMapping("/vue/httpdemo")
    public String httpdemo(){
        System.out.println("vue demo");
        return "vue_http_demo_3";
    }

    @GetMapping("/vuedemo2")
    public String vuedemo2(){
        System.out.println("vue demo 2");
        return "vue_demo_2";
    }

//    vue分离
//    https://www.cnblogs.com/nele/p/7858581.html
//      --- 代码编译不过

//    分离2
//    https://my.oschina.net/u/3491123/blog/1593600
//    0 -> https://blog.csdn.net/h295928126/article/details/73839012

    // 分离成功
//    https://my.oschina.net/u/3491123/blog/1593600

    // vue http请求 ，单html 测试 ok
    // https://www.cnblogs.com/alinaxia/p/6359074.html
    // code https://github.com/keepfool/vue-tutorials --> /03.Ajax/vue-resource
}
