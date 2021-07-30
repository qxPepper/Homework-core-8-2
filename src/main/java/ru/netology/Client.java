package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
//import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String phrase = "";
        try (Socket clientSocket = new Socket("netology.homework", 8082);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             //Scanner scanner = new Scanner(System.in);
        ) {

            System.out.println(in.readLine());
            //phrase = scanner.nextLine();
            phrase = "Vasya";
            System.out.println(">>" + phrase);
            out.println(phrase);

            System.out.println(in.readLine());
            //phrase = scanner.nextLine();
            phrase = "no";
            System.out.println(">>" + phrase);
            out.println(phrase);

            System.out.println(in.readLine());
            //phrase = scanner.nextLine();
            phrase = "And, what is your name?";
            System.out.println(">>" + phrase);
            out.println(phrase);

            System.out.println(in.readLine());
            //phrase = scanner.nextLine();
            phrase = "Yes, of course. I am tolerant of hardware!";
            System.out.println(">>" + phrase);
            out.println(phrase);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

