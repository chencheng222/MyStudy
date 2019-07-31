package com.cc.study.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
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

    /**
     * 将double型->字节数组
     * 以内存中的数据为基准，将数组写入到缓冲区时使用输出流
     *
     * @param num
     * @return
     */
    public static byte[] convert(double num) throws IOException {
        byte[] data = null;

        // 该类实现了将数据写入字节数组的输出流。 当数据写入缓冲区时，
        // 缓冲区会自动增长。 数据可以使用toByteArray()和toString() 。
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 该类将原始Java数据类型写入输出流
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeDouble(num);
        dos.flush();

        // 获取数据
        data = bos.toByteArray();
        dos.close();

        return data;
    }
}
