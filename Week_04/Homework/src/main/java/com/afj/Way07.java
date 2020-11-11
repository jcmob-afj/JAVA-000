package com.afj;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author afj
 * @Date 2020/11/11 10:25
 * @Version 1.0
 * @description: 方案7 启动新线程计算结果，用Condition条件变量控制两个线程同步
 */
public class Way07 {
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
        Lock lock = new ReentrantLock();
        Condition calcFinish = lock.newCondition();
        int[] result = new int[1];

        new Thread(() -> {
            lock.lock();
            result[0] = sum();
            calcFinish.signal();
            lock.unlock();
        }).start();
        try {
            lock.lock();
            calcFinish.await();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("异步计算结果为：" + result[0]);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        if (ANSWER == result[0]) {
            System.out.println("计算结果正确");
        }
        //思考：calcFinish 、lock的用法？
    }


}
