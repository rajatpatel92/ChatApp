
package chatapp.chat;

import java.io.IOException;

/**
 *
 * @author Rajat
 */
public class Client
{
    public static void main (String[] args) throws java.lang.NullPointerException, IOException{
        ChatFunctions cf = new ChatFunctions("Client");
        cf.clientChat();
        cf.occ.closeStreams();
    }
}
