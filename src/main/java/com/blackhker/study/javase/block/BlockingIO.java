package com.blackhker.study.javase.block;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author BLACKHKER
 * @Date 2023/4/26 14:44
 * @ClassName: BlockingIO
 * @Description: 阻塞IO示例：从网络上获取数据
 * @Version 1.0
 */
public class BlockingIO {
    public static void main(String[] args) throws IOException {

        //创建一个 URL 对象
        URL url = new URL("https://www.baidu.com");

        //打开 URL 连接
        URLConnection connection = url.openConnection();

        //获取输入流
        InputStream input = connection.getInputStream();

        //创建一个字节数组来缓存读取的数据
        byte[] data = new byte[4096];

        //从输入流中读取数据到缓存数组中，返回读取到的字节数
        int len = input.read(data);

        //如果读取到的字节数为 -1，表示文件已读完
        while (len != -1) {
            //将缓存数组中读取到的数据转换为字符串并打印出来
            String str = new String(data, 0, len);
            System.out.println(str);

            //继续读取下一部分的数据
            len = input.read(data);
        }
    }
}
