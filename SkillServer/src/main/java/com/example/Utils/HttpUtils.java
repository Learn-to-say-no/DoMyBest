package com.example.Utils;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 网络请求操作工具类
 */
public class HttpUtils {


    /**
     * 获取Http 链接
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static HttpURLConnection getHttpUrlconnection(String url) throws IOException {
        URL httpUrl = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
        return httpURLConnection;
    }


    /**
     * 获取网络文件的大小
     *
     * @param url
     * @param start
     * @param end
     * @return
     * @throws IOException
     */
    public static HttpURLConnection getHttpUrlConnection(String url, long start, Long end) throws IOException {
        HttpURLConnection httpUrlconnection = getHttpUrlconnection(url);
        LogUtils.debug("此线程下载内容区间 {}--{}", start, end);
        if (end != null) {
            httpUrlconnection.setRequestProperty("RANGE", "bytes=" + start + "-" + end);
        } else {
            httpUrlconnection.setRequestProperty("RANGE", "bytes=" + start + "-");
        }
        return httpUrlconnection;
    }


    /**
     * 获取网络文件 Etag
     *
     * @param url
     * @return
     */
    public static String getHttpFileEtag(String url) throws IOException {
        HttpURLConnection httpUrlconnection = getHttpUrlconnection(url);
//        String eTag = httpUrlconnection.getHeaderField("ETag");
        Map<String, List<String>> headerFields = httpUrlconnection.getHeaderFields();
        List<String> eTagList = headerFields.get("ETag");
        httpUrlconnection.disconnect();
        return eTagList.get(0);
    }


    public static String getHttpFileName(String url){
        int indexOf = url.lastIndexOf("/");
        return url.substring(indexOf + 1);
    }

}
