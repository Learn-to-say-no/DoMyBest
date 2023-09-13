package com.example.CollectionsPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/30 23:35
 */
public class ListQuestions {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a1");
        list.add("a2");
        list.add("b1");
        list.add("b2");
        for(String s : list){
            if("b1".equals(s)){
                list.remove(s);
            }
        }
    }
}
