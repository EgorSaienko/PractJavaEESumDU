/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laba2server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.mycompany.laba2server.ChatServer;

public class ClientThread implements Runnable {
    Socket clientSocket;
    ChatServer chatServer;
    int numberClient;

    public ClientThread(Socket clientSocket, ChatServer chatServer, int number) {
        this.clientSocket = clientSocket;
        this.chatServer = chatServer;
        this.numberClient = number;
    }
        
        @Override
        public void run() {
    try (
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
    ) {
        System.out.println("Client №" + numberClient + " connected.");
        out.println("Client №" + numberClient + ".");
        String clientMessage;

        while ((clientMessage = in.readLine()) != null) {
            if (!"exit".equals(clientMessage)) {
                System.out.println("Client №" + numberClient + ": " + clientMessage);
                chatServer.sendMessageForAllClient(numberClient, clientMessage);
            } else {
                break;
            }
        }
    }catch (IOException e) {
        System.err.println("Error handling client #" + numberClient + ": " + e.getMessage());
    } finally {
        try {
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error closing client #" + numberClient + " socket: " + e.getMessage());
        }
        chatServer.removeClient(numberClient); // Assuming you have a method to remove client from the server
        System.out.println("Client #" + numberClient + " disconnected.");
    }
}
}
        
        
        
        