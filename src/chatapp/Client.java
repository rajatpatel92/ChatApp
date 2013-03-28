
package chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rajat
 */
public class Client
{
        public static PrintWriter toServer = null;
        public static BufferedReader fromServer = null;
        public static Socket socket = null;
        public static void main (String[] args) throws java.lang.NullPointerException, IOException{
            try {
                socket = new Socket("127.0.0.1",3000);
                toServer = new PrintWriter(socket.getOutputStream(),true);
                fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            String msg = "";
            Scanner scanner = new Scanner(System.in);
            while (!"exit".equals(msg))
            {
                System.out.print("You : ");
                msg = scanner.nextLine();
                toServer.println(msg);
                String tmp = fromServer.readLine();
                System.out.println("Server : " + tmp);
            }
            fromServer.close();
            toServer.close();
            socket.close();
        }
}
