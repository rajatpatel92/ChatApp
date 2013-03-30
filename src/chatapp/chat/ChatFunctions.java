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
        toServer a = new toServer();
        fromServer b = new fromServer();
        //while (!"exit".equals(a.msg)){
            a.ts.start();
            b.fs.start();
        //}
        /*String msg = "";
        Scanner scanner = new Scanner(System.in);
        while (!"exit".equals(msg)){
            System.out.print("You : ");
            msg = scanner.nextLine();
            occ.toServer.println(msg);
            String tmp = occ.fromServer.readLine();
            System.out.println("Server : " + tmp);
        }*/
    }
    
    public void serverChat() throws IOException{
        //String msg;
        //String reply;
        toClient a = new toClient();
        fromClient b = new fromClient();
        //do {
            a.tc.start();
            b.fc.start();
            /*msg = osc.fromClient.readLine();
            System.out.println("Client : "+msg);
            Scanner sc = new Scanner(System.in);
            System.out.print("Server : ");
            reply = sc.nextLine();
            osc.toClient.println(reply);*/
        //} while (true);
    }
    
    class toClient implements Runnable{
        Thread tc = new Thread(this, "toClient");;
        String reply;
        Scanner sc;
        public toClient(){
           // tc = 
            //tc.start();
        }
        @Override
        public void run() {
            while(true){
                sc = new Scanner(System.in);
                System.out.println("Server : ");
                reply = sc.nextLine();
                osc.toClient.print(reply);
            }
        }
    }


    class fromClient implements Runnable{
        Thread fc = new Thread(this, "fromClient");
        String msg;
        public fromClient(){
            //fc 
            //fc.start();
        }
        @Override
        public void run() {
            while (true){
                try {
                    msg = osc.fromClient.readLine();
                    System.out.println("Client : "+msg);
                } catch (IOException ex) {
                    Logger.getLogger(ChatFunctions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    class toServer implements Runnable{
        Thread ts = new Thread(this, "toServer");
        String msg;
        Scanner scanner;
        public toServer(){
            //ts ;
            //ts.start();
        }
        @Override
        public void run() {
            while(true){
                System.out.print("You : ");
                scanner = new Scanner(System.in);
                msg = scanner.nextLine();
                occ.toServer.println(msg);
            } 
        }
    }

    class fromServer implements Runnable{
        Thread fs = new Thread(this, "fromServer");
        public fromServer(){
            //fs 
            //fs.start();
        }
        @Override
        public void run() {
            while(true){
                try {
                    String tmp = occ.fromServer.readLine();
                    System.out.println("Server : " + tmp);
                } catch (IOException ex) {
                    Logger.getLogger(ChatFunctions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}



