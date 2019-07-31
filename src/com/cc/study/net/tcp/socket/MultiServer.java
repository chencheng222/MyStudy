package com.cc.study.net.tcp.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public static void main(String[] args) throws IOException {
        // 创建服务器，指定端口
        ServerSocket server = new ServerSocket(8888);

        while (true) {

            // 接受客户端连接  阻塞式
            Socket socket = server.accept();

            System.out.println("建立连接...");

            // 发送数据  以输出流的形式
            String msg = "欢迎使用";
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(msg);

            dos.flush();
        }

    }
}
