package com.cc.study.net.tcp.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {
    private DataInputStream dis = null;
    private boolean isRunning = true;

    public Receive(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dis);
        }
    }

    private String receiveMsg() {
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dis);
        }

        return msg;
    }

    @Override
    public void run() {
        while (isRunning) {
            String msg = receiveMsg();
            System.out.println(msg);
        }
    }
}
