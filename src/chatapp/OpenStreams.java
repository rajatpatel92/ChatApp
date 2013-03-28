/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Rajat
 */
class OpenServerStreams {
    private ServerSocket serverSocket;
    private Socket socket;
    OutputStream os;
    //ByteArrayOutputStream out;
    //InputStreamReader in;
    public void openStreams() throws IOException{
        serverSocket = new ServerSocket(5555);
        socket = serverSocket.accept();
        System.out.println("Accepted connection : " + socket);
        os = socket.getOutputStream();
        //out = new ByteArrayOutputStream();
        //out.writeTo(socket.getOutputStream());
        //in = new InputStreamReader(socket.getInputStream());
    }
}

class OpenClientStreams {
    Socket clientSocket;
    InputStream is;
    public void openStreams() throws IOException{
        clientSocket = new Socket("127.0.0.1", 5555);
        System.out.println("Connecting...");
        is = clientSocket.getInputStream();
        //out = new ByteArrayOutputStream();
        //out.writeTo(clientSocket.getOutputStream());
        //in = new InputStreamReader(clientSocket.getInputStream());
    }
}
