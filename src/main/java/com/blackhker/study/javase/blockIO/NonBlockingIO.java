package com.blackhker.study.javase.blockIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Author BLACKHKER
 * @Date 2023/4/26 14:51
 * @ClassName: NonBlockingIO
 * @Description: 非阻塞IO示例：从网络上获取数据 TODO 网络编程部分不理解
 * @Version 1.0
 */
public class NonBlockingIO {
    public static void main(String[] args) throws IOException {

        // 创建一个客户端 SocketChannel
        SocketChannel socketChannel = SocketChannel.open();
        // 配置非阻塞模式
        socketChannel.configureBlocking(false);
        // 连接服务器
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

        // 创建一个 Selector
        Selector selector = Selector.open();
        // 将 SocketChannel 注册到 Selector 上并监听连接就绪事件
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        // 不断轮询就绪的 Channel
        while (true) {
            selector.select();
            // 获取所有就绪的 SelectionKey
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                keyIterator.remove();

                // Connect 操作就绪
                if (key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                        System.out.println("连接成功！");
                    }
                    // 将 SocketChannel 注册到 Selector 上并监听读就绪事件
                    channel.register(selector, SelectionKey.OP_READ);
                }
                // Read 操作就绪
                else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    // 创建一个 ByteBuffer 来缓存读取的数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    // 从 SocketChannel 中读取数据到 ByteBuffer 中，返回读取到的字节数
                    int len = channel.read(buffer);
                    // 如果读取到的字节数大于 0，表示读取到了数据
                    if (len > 0) {
                        buffer.flip();
                        // 将 ByteBuffer 中读取到的数据转换成字符串并打印出来
                        String str = new String(buffer.array(), 0, len);
                        System.out.println(str);
                    }
                }
            }
        }
    }
}
