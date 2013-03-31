/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.chat;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rajat
 */
class ChatFunctions {
    OpenServerChat osc;
    OpenClientChat occ;
    ChatFunctions(String a) throws IOException{
        switch (a) {
            case "Server":
                osc =  new OpenServerChat();
                osc.openStreams();
                break;
            case "Client":
                occ = new OpenClientChat();
                occ.openStreams();
                break;
        }
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
            osc.toClient.print(reply);
        }
        synchronized public void fromClient(){
            String msg;
            //while (true){
                try {
                    msg = osc.fromClient.readLine();
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
            occ.toServer.println(msg);
            
        }
        synchronized public void fromServer(){
            try {
                    String tmp = occ.fromServer.readLine();
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



