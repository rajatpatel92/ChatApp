/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Rajat
 */
public class Server {
       private static ServerSocket serverSocket;
        private static Socket socket;
        private static PrintWriter toClient;
        private static BufferedReader fromClient;
        public static void run() throws IOException{
            System.out.println("Server is waiting for connections...");
            while (true)
            {
                openStreams();
                processClient();
                closeStreams();
            }
        }

        public static void openStreams() throws IOException{
            serverSocket = new ServerSocket(3000);
            socket = serverSocket.accept();
            toClient = new PrintWriter(socket.getOutputStream(),true);
            fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        public static void closeStreams() throws IOException{
            fromClient.close();
            toClient.close();
            socket.close();
            serverSocket.close();
        }
        public static void processClient()throws IOException{
            String msg;
            String reply;
            do {
                msg = fromClient.readLine();
                System.out.println("Client : "+msg);
                Scanner sc = new Scanner(System.in);
                
                System.out.print("Server : ");
                reply = sc.nextLine();
                toClient.println(reply);
            } while (!"exit".equals(msg));
        }
}

