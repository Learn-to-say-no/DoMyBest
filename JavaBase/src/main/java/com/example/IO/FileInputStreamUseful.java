package com.example.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/17 23:00
 */
public class FileInputStreamUseful {
    public static void main(String[] args) {
        //写出数据到文件中
        try (OutputStream fos = new FileOutputStream("JavaBase/output.txt")){
            byte[] array = "you known".getBytes();
            fos.write(array);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
