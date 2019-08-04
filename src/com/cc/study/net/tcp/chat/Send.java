package com.cc.study.net.tcp.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端发送数据
 */
public class Send implements Runnable {
    // 控制台输入流
    private BufferedReader reader = null;
    // socket输出流
    private DataOutputStream dos = null;
    // 线程运行状态
    private boolean isRunning = true;


    public Send() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client) {
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            CloseUtil.closeAll(dos, reader);
            isRunning = false;
        }
    }

    /**
     * 控制台输入消息取得
     *
     * @return msg
     */
    private String getMsg() {
        String msg = "";
        try {
            msg = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            CloseUtil.closeAll(dos, reader);
            isRunning = false;
        }

        return msg;
    }

    /**
     * 发送
     */
    private void sendMsg() {
        String msg = getMsg();
        if (!"".equals(msg)) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                CloseUtil.closeAll(dos, reader);
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            sendMsg();
        }
    }
}
