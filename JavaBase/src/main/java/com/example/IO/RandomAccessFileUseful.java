package com.example.IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @description: 随机访问流
 * @author: muqingfeng
 * @date: 2023/8/17 23:30
 */
public class RandomAccessFileUseful {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("JavaBase/input.txt"), "rw");
        System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() + ",当前读取到的字符" + (char) randomAccessFile.read() + "，读取之后的偏移量：" + randomAccessFile.getFilePointer());
        // 指针当前偏移量为 6
        randomAccessFile.seek(6);
        System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() + ",当前读取到的字符" + (char) randomAccessFile.read() + "，读取之后的偏移量：" + randomAccessFile.getFilePointer());
        // 从偏移量 7 的位置开始往后写入字节数据
        randomAccessFile.write(new byte[]{'H', 'I', 'J', 'K'});
        // 指针当前偏移量为 0，回到起始位置
        randomAccessFile.seek(0);
        System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() + ",当前读取到的字符" + (char) randomAccessFile.read() + "，读取之后的偏移量：" + randomAccessFile.getFilePointer());

    }
}
