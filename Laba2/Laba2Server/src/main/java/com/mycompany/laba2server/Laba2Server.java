package com.mycompany.laba2server;

import com.mycompany.laba2server.ChatServer;
/**
 *
 * @author Admin
 */

public class Laba2Server {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        Thread tChatServer = new Thread((Runnable) chatServer);
        tChatServer.start();
    }
}
