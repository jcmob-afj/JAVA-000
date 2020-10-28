package com.xxl.job.executor.common.utils;

import java.io.IOException;


import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author afj
 * @Date 2020/10/28 23:19
 * @Version 1.0
 * @description:
 */
public class OkHttpClient {
    /**
     * socket服务地址信息
     */
    private static final String SERVER_URL ="http://localhost:8801";


    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        try{
            System.out.println("访问8801端口服务成功，返回信息为：" + new OkVisitor().doOKHttpClientRequest(SERVER_URL));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("访问8801端口服务失败！");
        }
    }

    /**
     * 访问服务，并返回服务输出的信息。
     * @param url
     * @return
     * @throws IOException
     */
    public String OKHttpClientRequest(String url)throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
