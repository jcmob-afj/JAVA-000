package com.afj;

/**
 * @Author afj
 * @Date 2020/11/11 9:58
 * @Version 1.0
 * @description:
 */
public class Homework03 {

    /**
     * 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？ 写出你的方法，越多越好，提交到 Github
     * @param args
     */

    
    
    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        //这是得到的返回值
        int result = sum();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

  

    public static int sum() {
        return fibo(40);
    }

    public static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
}