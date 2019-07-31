package com.cc.study.net.tcp.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 创建客户端连接
        Socket client = new Socket("localhost", 8888);

        // 接收数据  以输入流的方式
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();

        System.out.println(msg);
    }
}
