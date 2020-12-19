package com.example.demo.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final int tt = 1;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost",8189),10000);
        socket.setSoTimeout(30000);
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream,"UTF-8");
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }


    }
}
