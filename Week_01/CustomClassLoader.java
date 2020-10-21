package com.cnhqd.platform.app3.utils;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @Author afj
 * @Date 2020/10/20 11:35
 * @Version 1.0
 * @description:
 */
public class CustomClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        //读取resource下的Hello.xlass
        File file = org.springframework.util.ResourceUtils.getFile("classpath:Hello.xlass");
        //获取文件长度
        int length = (int) file.length();
        //定义同文件长度的byte[]
        byte[] bytes = new byte[length];
        //将文件中的值都放入byte[]中
        new FileInputStream(file).read(bytes);
        for (int i = 0; i < length; i++) {
            //将字节码文件的值转换过来
            bytes[i] = (byte) (255 - bytes[i]);
        }
        Class<?> cls = new CustomClassLoader().defineClass("Hello", bytes, 0, bytes.length);
        Object obj = cls.newInstance();
        Method method = cls.getMethod("hello");
        method.invoke(obj);
    }


}
