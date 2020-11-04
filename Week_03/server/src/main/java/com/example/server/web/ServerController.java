package com.example.server.web;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @Author afj
 * @Date 2020-10-28 14:56:38
 * @Version 1.0
 * @description: server
 */
@RestController
public class ServerController {


    /**
     * 返回hello
     *
     * @return 单条数据
     */
    @GetMapping("")
    public String hello() throws UnsupportedEncodingException {
        String hello = System.getProperty("hello", "hello I'm server !");
        System.out.println(hello);
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(hello.getBytes("UTF-8")));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", hello.getBytes().length);
        return hello;
    }


}