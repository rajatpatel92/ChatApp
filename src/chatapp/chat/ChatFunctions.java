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
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rajat
 */
final class ChatFunctions {
    OpenServerChat osc;
    OpenClientChat occ;
    Socket client_socket;//updated from socket
    Socket server_socket;//updated from socket
    PrintWriter toServer;
    PrintWriter toClient;
    ServerSocket serverSocket;
    BufferedReader fromServer;
    BufferedReader fromClient;
    ChatFunctions(String a) throws IOException{
        switch (a) {
            case "Server":
                //osc =  new OpenServerChat();
                openServerStreams();
                break;
            case "Client":
                //occ = new OpenClientChat();
                openClientStreams();
                break;
        }
    }
    public void openClientStreams() throws UnknownHostException, IOException{
        client_socket = new Socket("127.0.0.1",3000);//a change here
        toServer = new PrintWriter(client_socket.getOutputStream(),true);
        fromServer = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
    }
    public void closeClientStreams() throws IOException{
        fromServer.close();
        toServer.close();
        client_socket.close();//a change here
    }
    public void openServerStreams() throws IOException{
        serverSocket = new ServerSocket(3000);
        server_socket = serverSocket.accept();//a change here
        toClient = new PrintWriter(server_socket.getOutputStream(),true);
        fromClient = new BufferedReader(new InputStreamReader(server_socket.getInputStream()));
    }
    public void closeServerStreams() throws IOException{
        fromClient.close();
        toClient.close();
        server_socket.close();//a change here
        serverSocket.close();
   }
    public void clientChat() throws IOException{
        new ClientThread().t2.start();
    }
    
    public void serverChat() throws IOException{
        new ServerThread().t.start();
    }
    
    class ServerThread implements Runnable{
        Thread t;
        public ServerThread(){
            t = new Thread(this, "SevrerThread");
            //t.start();
        }
        synchronized public void toClient(){
            String reply;
            Scanner sc;
            sc = new Scanner(System.in);
            System.out.println("Server : ");
            reply = sc.nextLine();
            toClient.print(reply);
        }
        synchronized public void fromClient(){
            String msg;
            //while (true){
                try {
                    msg = fromClient.readLine();
                    System.out.println("Client : "+msg);
                } catch (IOException ex) {
                    Logger.getLogger(ChatFunctions.class.getName()).log(Level.SEVERE, null, ex);
                }
            //}
        }

        @Override
        public void run() {
            while(true){
                this.toClient();
                this.fromClient();
            }
        }
    }
    
    class ClientThread implements Runnable{
        Thread t2;
        public ClientThread(){
            t2 = new Thread(this, "ClientThread");
        }
        synchronized public void toServer(){
            String msg;
            Scanner scanner;
            System.out.print("You : ");
            scanner = new Scanner(System.in);
            msg = scanner.nextLine();
            toServer.println(msg);
            
        }
        synchronized public void fromServer(){
            try {
                    String tmp = fromServer.readLine();
                    System.out.println("Server : " + tmp);
                } catch (IOException ex) {
                    Logger.getLogger(ChatFunctions.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        @Override
        public void run() {
            while(true){
                this.toServer();
                this.fromServer();
            }
        }
    }
}
