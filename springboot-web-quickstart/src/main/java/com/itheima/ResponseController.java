package com.itheima;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {


    //方式1：使用HttpServletResponse对象
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //设置响应状态码
        response.setStatus(200);
        //设置响应头
        response.setHeader("name", "itheima");
        //设置响应体
        response.getWriter().write("<h1>hello response</h1>");
    }

    //方式2：使用ResponseEntity对象 - Spring中提供的方式
    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("name", "JavaWeb-AI")
                .body("<h1>hello response</h1>");
    }
}
