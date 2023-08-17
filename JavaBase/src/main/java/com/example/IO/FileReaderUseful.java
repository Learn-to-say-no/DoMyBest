package com.example.IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/17 23:01
 */
public class FileReaderUseful {
    public static void main(String[] args) {
        //从文件中读取字符数据
        try (FileReader fr = new FileReader("JavaBase/input.txt")) {
            int content;
            long skip = fr.skip(2);
            System.out.println("actual number of bytes skipped: " + skip);
            System.out.println("The content read from file:");
            while ((content = fr.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
