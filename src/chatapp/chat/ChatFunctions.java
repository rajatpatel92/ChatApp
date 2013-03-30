/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.chat;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Rajat
 */
public class ChatFunctions {
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
        String msg = "";
        Scanner scanner = new Scanner(System.in);
        while (!"exit".equals(msg))
        {
            System.out.print("You : ");
            msg = scanner.nextLine();
            occ.toServer.println(msg);
            String tmp = occ.fromServer.readLine();
            System.out.println("Server : " + tmp);
        }
    }
    
    public void serverChat() throws IOException{
        String msg;
        String reply;
        do {
            msg = osc.fromClient.readLine();
            System.out.println("Client : "+msg);
            Scanner sc = new Scanner(System.in);
            System.out.print("Server : ");
            reply = sc.nextLine();
            osc.toClient.println(reply);
        } while (true);
    }
}
