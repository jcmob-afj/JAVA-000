package com.afj;

/**
 * @Author afj
 * @Date 2020/11/11 10:25
 * @Version 1.0
 * @description: 方案11 利用Object类的wait notify机制进行线程同步
 */
public class Way11 {
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
        int[] result = new int[1];
        new Thread(() -> {
            synchronized (Way11.class) {
                result[0] = sum();
                Way11.class.notify();
            }
        }).start();

        try {
            synchronized (Way11.class) {
                Way11.class.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("异步计算结果为：" + result[0]);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        if (ANSWER == result[0]) {
            System.out.println("计算结果正确");
        }

    }


}
