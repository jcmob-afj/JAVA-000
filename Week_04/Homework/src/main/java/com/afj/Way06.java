package com.afj;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author afj
 * @Date 2020/11/11 10:25
 * @Version 1.0
 * @description: 方案6 启动新线程计算结果，用LinkedBlockingQueue传递计算结果，新线程计算完成之前主线程阻塞在LinkedBlockingQueue获取数据的方法上
 */
public class Way06 {
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
        LinkedBlockingQueue<Integer> que = new LinkedBlockingQueue<Integer>();
        new Thread(() -> {
            try {
                que.put(sum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        int result = 0;
        try {
            result = que.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        if (ANSWER == result) {
            System.out.println("计算结果正确");
        }
        //思考：l LinkedBlockingQueue  put、take方法？
    }


}
