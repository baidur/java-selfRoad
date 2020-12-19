package com.example.demo.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        Socket incoming = serverSocket.accept();
        InputStream inputStream = incoming.getInputStream();
        OutputStream outputStream = incoming.getOutputStream();
        Scanner scanner = new Scanner(inputStream,"UTF-8");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8),true);
        out.println("Hello! Enter BYE to exit");
        boolean done = false;
        while (!done && scanner.hasNextLine()){
            out.println(scanner.nextLine());
            if(scanner.nextLine().trim().equals("BYE")){
                done = true;
            }
        }
    }
}
