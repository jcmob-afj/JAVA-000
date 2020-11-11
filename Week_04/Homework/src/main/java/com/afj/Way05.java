package com.afj;

import java.util.concurrent.Semaphore;

/**
 * @Author afj
 * @Date 2020/11/11 10:25
 * @Version 1.0
 * @description: 方案5 启动新线程计算结果，用Semaphone通知主线程计算结束
 */
public class Way05 {
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
        Semaphore s = new Semaphore(0);

        int[] result = new int[1];
        new Thread(() -> {
            result[0] = sum();
            s.release();
        }).start();
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + result[0]);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        if (ANSWER == result[0]) {
            System.out.println("计算结果正确");
        }
        //思考：l  s.release() ; s.acquire() 先后顺序 ？
    }


}
