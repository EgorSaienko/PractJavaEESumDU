package com.mycompany.laba2server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer implements Runnable {
    private Map<Integer, Socket> mapClient = new ConcurrentHashMap<>(); // Використовуйте ConcurrentMap для безпечної роботи з багатопоточністю

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(8887);
            System.out.println("Server started. Waiting for clients.");
            int numberClient = 1;

            while (true) {
                Socket client = server.accept();
                mapClient.put(numberClient, client);

                Thread clientThread = new Thread(new ClientThread(client, this, numberClient));
                clientThread.setDaemon(true);
                clientThread.start();
                
                numberClient++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void sendMessageForAllClient(int senderNumber, String message) {
        for (Map.Entry<Integer, Socket> entry : mapClient.entrySet()) {
            int clientNumber = entry.getKey();
            Socket clientSocket = entry.getValue();
            try {
                if (clientNumber != senderNumber) {
                    PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true);
                    clientOut.println("Client #" + senderNumber + ": " + message);
                }

            } catch (IOException e) {
                System.err.println("Error sending message to client #" + clientNumber + ": " + e.getMessage());
                // Handle the exception or remove the client from the map, based on your requirements
            }
        }
    }

    public void removeClient(int numberClient) {
        mapClient.remove(numberClient);
        System.out.println("Client #" + numberClient + " removed.");
    }
}