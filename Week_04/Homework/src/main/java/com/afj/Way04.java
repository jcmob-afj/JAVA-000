package com.afj;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author afj
 * @Date 2020/11/11 10:25
 * @Version 1.0
 * @description: 方案4 CompletableFuture异步获取结果
 */
public class Way04 {
    private static final int ANSWER = 165580141;

    private static int sum() {
        return fibo(40);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int result = 0;
        try {
            result = CompletableFuture.supplyAsync(() -> {
                return sum();
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        if (ANSWER == result) {
            System.out.println("计算结果正确");
        }
        //思考：l CompletableFuture 的用法？
    }


}
