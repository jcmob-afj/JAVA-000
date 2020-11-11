package com.afj;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author afj
 * @Date 2020/11/11 10:25
 * @Version 1.0
 * @description: 方案8 CyclicBarrier控制线程同步
 */
public class Way08 {
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
        CyclicBarrier barrier = new CyclicBarrier(2);
        int[] result = new int[1];

        new Thread(() -> {
            result[0] = sum();
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }


        System.out.println("异步计算结果为：" + result[0]);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        if (ANSWER == result[0]) {
            System.out.println("计算结果正确");
        }
        //思考：CyclicBarrier 、await？
    }


}
