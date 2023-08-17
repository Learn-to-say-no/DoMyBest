package com.example.IO;

import java.io.*;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/17 23:04
 */
public class BufferInputStreamUseful {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/muqingfeng/Desktop/文科一分一段表.pdf"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("JavaBase/文科一分一段表-副本.pdf"))){
            System.out.println("all available: "+ bis.available());
            int content;
            System.out.println("content");
            while((content = bis.read())  != -1){
                bos.write(content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+ (end - start) + " ms");
    }
}
