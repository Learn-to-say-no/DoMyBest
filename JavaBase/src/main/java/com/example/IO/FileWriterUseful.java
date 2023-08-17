package com.example.IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/17 23:01
 */
public class FileWriterUseful {
    public static void main(String[] args) {
        //写出字符到文件中
        try(FileWriter fw = new FileWriter("JavaBase/outputString.txt")){
            fw.write("你知道的，没有什么难得倒我");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

