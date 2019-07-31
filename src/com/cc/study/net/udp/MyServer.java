package com.cc.study.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP：服务器端
 * 	1)、创建服务器  DatagramSocket 类+指定端口
 * 	2)、准备接受容器->字节数组  封装DatagramPacket
 * 	3)、包  接受数据
 * 	4)、分析
 *  5)、释放资源
 *
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        // 创建服务器  DatagramSocket 类+指定端口
        DatagramSocket server = new DatagramSocket(8888);

        // 准备接受容器-
        byte[] container = new byte[1024];

        // 封装成包 DatagramPacket(byte[] buf, int length)
        DatagramPacket packet = new DatagramPacket(container, container.length);

        // 接受数据
        server.receive(packet);

        // 分析数据
        byte[] data = packet.getData();
        int length = packet.getLength();

        System.out.println(new String(data, 0, length));

        // 释放资源
        server.close();

    }

    /**
     * 将字节数组读取转为double
     * 将缓冲区内容写入内存中时，使用输入流
     *
     * @param data
     * @return
     * @throws IOException
     */
    public static double conver(byte[] data) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        double num = dis.readDouble();
        dis.close();

        return num;
    }

}
