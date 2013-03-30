
package chatapp.chat;

import java.io.IOException;

/**
 *
 * @author Rajat
 */
public class Server {
    public static void runServer() throws IOException{
        System.out.println("Server is waiting for clients to initiate chat.....");
        while (true)
        {
            ChatFunctions cf = new ChatFunctions("Server");
            System.out.println("Connected : "+ cf.osc.socket);
            cf.serverChat();
            cf.osc.closeStreams();
        }
    }
}

