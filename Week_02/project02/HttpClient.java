package com.cnhqd.common.utils;

/**
 * @Author afj
 * @Date 2020/10/29 14:54
 * @Version 1.0
 * @description:
 */
public class HttpClient {
    /**
     * socket服务地址信息
     */
    private static final String SERVER_URL ="http://localhost:8801";


    public static void main(String[] args) {
        String result = HttpClientUtil.doGet(SERVER_URL);
        System.out.println(result);
    }
}
