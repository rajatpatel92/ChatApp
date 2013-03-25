/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Rajat
 */


public class Server {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static BufferedReader bufferedReader;
    private static String inputLine;
    //int port;
    public void createServer() throws IOException {
        serverSocket = new ServerSocket(5000);
        clientSocket = serverSocket.accept();
        // Create a reader
        bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        // Get the client message
        while((inputLine = bufferedReader.readLine()) != null)
        System.out.println(inputLine);
    }
}
