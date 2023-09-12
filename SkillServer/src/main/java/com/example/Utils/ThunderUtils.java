package com.example.Utils;

/**
 * 迅雷链接转换工具
 */
public class ThunderUtils {

    private static String THUNDER = "thunder://";


    /**
     * 判断是否是迅雷链接
     * @param url
     * @return
     */
    public static boolean isThunderLink(String url){
        return url.startsWith(THUNDER);
    }
}
