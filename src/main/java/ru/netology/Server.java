package ru.netology;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String phrase = "";
        String name = "";
        try (ServerSocket serverSocket = new ServerSocket(8082);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Write your name.");

            name = in.readLine();
            out.println(name + ", are you child? (yes/no)");

            phrase = in.readLine();
            if (phrase.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            } else {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            }

            out.println("My name is Server. I'm a piece of iron. Will you be interested in me?");

        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

