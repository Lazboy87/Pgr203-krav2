package no.kristiana.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Httpserver {


    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(8080);

        Socket socket = serversocket.accept();

        StringBuilder line = new StringBuilder();
        int c;
        while ((c = socket.getInputStream().read()) != -1) {
            if (c=='\r'){
                c = socket.getInputStream().read();
                System.out.println(line);
                if (line.toString().isBlank()){
                    break;
                }
                line = new StringBuilder();
            }
            line.append((char)c);

        }

        socket.getOutputStream().write(("HTTP/1.1 200 OK\r\n"+
                "Content-type: text/plain\r\n"+
                "Content-length: 12\r\n"+
                "Connection: close\r\n"+
                "\r\n"+
                "Hello World!").getBytes());
    }

}
