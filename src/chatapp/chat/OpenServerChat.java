/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Rajat
 */
public class OpenServerChat {
    ServerSocket serverSocket;
    Socket socket;
    PrintWriter toClient;
    BufferedReader fromClient;
    public void openStreams() throws IOException{
        serverSocket = new ServerSocket(3000);
        socket = serverSocket.accept();
        toClient = new PrintWriter(socket.getOutputStream(),true);
        fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    public void closeStreams() throws IOException{
        fromClient.close();
        toClient.close();
        socket.close();
        serverSocket.close();
   }
}
