package com.example.Base.Struct;

import org.junit.Test;


public class MyStackTest {

    @Test
    public void main(){
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        System.out.println(myStack.peek());
    }

}
