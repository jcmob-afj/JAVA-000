package com.afj;

/**
 * @Author afj
 * @Date 2020/11/11 10:25
 * @Version 1.0
 * @description: 方案3 将结果对象传入匿名Runnable对象，在其run方法中对结果进行设置，主线程等待计算线程结束，然后读取结果，利用堆中的公共对象传递结果
 */
public class Way03 {
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
        final int[] result = new int[1];

        Thread t = new Thread(() -> {
            result[0] = sum();
        });
        try {
            t.start();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + result[0]);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        if (ANSWER == result[0]) {
            System.out.println("计算结果正确");
        }
        //思考：l Lambda表达是的写法，为什么用result[]接收返回参数
        //     2.怎么确定退出主线程了？
    }


}
