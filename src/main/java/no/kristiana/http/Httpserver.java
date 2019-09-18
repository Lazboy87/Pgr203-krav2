package no.kristiana.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Httpserver {


    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(8080);

        Socket socket = serversocket.accept();

        int c;
        while ((c = socket.getInputStream().read()) != -1) {
            System.out.print((char) c);
        }
    }

}
