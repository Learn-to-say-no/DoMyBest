package com.example.IO;

import java.io.*;

/**
 * @description: FileOutStream 使用
 * @author: muqingfeng
 * @date: 2023/8/17 21:41
 */
public class FileOutStreamUseful {

    public static void main(String[] args) {
        //从文件中读取字节数据
        try (InputStream fis = new FileInputStream("JavaBase/input.txt")) {
            System.out.println("Number of remaining bytes: " + fis.available());
            int content;
            long skip = fis.skip(2);
            System.out.println("actual number of bytes skipped: " + skip);
            System.out.println("The content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //字节流读取数据
        long start = System.currentTimeMillis();
        try(FileInputStream fis = new FileInputStream("/Users/muqingfeng/Desktop/文科一分一段表.pdf");
        FileOutputStream fos = new FileOutputStream("JavaBase/文科一分一段表.pdf")){
            System.out.println("all available: "+ fis.available());
            int content;
            System.out.println("content");
            while((content = fis.read())  != -1){
                fos.write(content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+ (end - start) + " ms");




    }
}
