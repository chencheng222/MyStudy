package com.cc.study.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * UDP：客户端
 * 	1)、创建客户端  DatagramSocket类+指定端口
 * 	2)、准备数据  字节数组
 * 	3)、打包  DatagramPacket+服务器地址 及 端口
 * 	4)、发送
 * 	5)、释放资源
 *
 */
public class MyClient {

    public static void main(String[] args) throws IOException {

        // 创建客户端
        DatagramSocket client = new DatagramSocket(6666);

        // 准备数据
        String msg = "Hello World";
        byte[] data = msg.getBytes();

        // 打包
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));

        // 发送
        client.send(packet);

        // 释放
        client.close();
    }
}
