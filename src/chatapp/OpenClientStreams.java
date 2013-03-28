/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author Rajat
 */
public class OpenClientStreams {
    Socket clientSocket;
    InputStream is;
    public void openStreams() throws IOException{
        clientSocket = new Socket("127.0.0.1", 5995);
        System.out.println("Connecting...");
        is = clientSocket.getInputStream();
        System.out.println("Connected to server");
    }
}
