package com.example.IO.NIO;

import java.nio.CharBuffer;

/**
 * @description: Buffer 中数据变化的过程
 * @author: muqingfeng
 * @date: 2023/8/19 14:55
 */
public class CharBufferDemo {
    public static void main(String[] args) {
        //分配一个容量为8的charBuffer
        CharBuffer buffer = CharBuffer.allocate(8);
        System.out.println("初始状态：");
        printState(buffer);

        //想buffer中写入3个字符
        buffer.put('a').put('b').put('c');
        System.out.println("写入三个字符后的状态： ");
        printState(buffer);

        //调用flip()方法，准备读取buffer中数据，将position置为0，limit的置为3
        buffer.flip();
        System.out.println("调用flip()方法后的状态： ");
        printState(buffer);

        //读取字符
        while (buffer.hasRemaining()){
            System.out.print(buffer.get());
        }

        //调用clear()，清空缓冲区，将position 的值置为0，将limit的值置为capacity
        buffer.clear();
        System.out.println("调用clear（）方法后的状态：");
        printState(buffer);

        //想buffer中写入3个字符
        buffer.put('d').put('e').put('f');
        System.out.println("写入三个字符后的状态： ");
        printState(buffer);

        //调用flip()方法，准备读取buffer中数据，将position置为0，limit的置为3
        buffer.flip();
        System.out.println("调用flip()方法后的状态： ");
        printState(buffer);

        //读取字符
        while (buffer.hasRemaining()){
            System.out.print(buffer.get());
        }
    }

    private static void printState(CharBuffer buffer) {
        System.out.print("capacity: "+ buffer.capacity());
        System.out.print(", limit: "+ buffer.limit());
        System.out.print(", position: "+ buffer.position());
        System.out.print(", mark 开始读取的字符: "+ buffer.mark());
        System.out.println("\n");
    }
}
