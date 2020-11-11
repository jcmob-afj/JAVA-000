package com.afj;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author afj
 * @Date 2020/11/11 10:25
 * @Version 1.0
 * @description: 方案1 线程池submit提交Callable接口实现类的实例，在实例中返回结果，主线程用Future对象异步获取结果
 */
public class Way01 {
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
        ExecutorService pool = Executors.newSingleThreadExecutor();
//        ExecutorService pool = Executors.newFixedThreadPool(16);
//        ExecutorService pool = Executors.newCachedThreadPool();
//        ScheduledExecutorService pool = Executors.newScheduledThreadPool(16);
        Future<Integer> f = pool.submit(
                () -> {
                    return sum();
                }
        );
        pool.shutdown();
        //这是得到的返回值
        int result = 0;
        try {
            result = f.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        if (ANSWER == result) {
            System.out.println("计算结果正确");
        }
        //思考：为什么用了线程池以后，执行的效率反而比单线程执行效率低了？
    }


}
