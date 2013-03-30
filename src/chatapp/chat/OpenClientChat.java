/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Rajat
 */
public class OpenClientChat {
    Socket socket;
    PrintWriter toServer;
    BufferedReader fromServer;
    public void openStreams() throws UnknownHostException, IOException{
        socket = new Socket("127.0.0.1",3000);
        toServer = new PrintWriter(socket.getOutputStream(),true);
        fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    public void closeStreams() throws IOException{
        fromServer.close();
        toServer.close();
        socket.close();
    }
}
