
package chatapp;

import java.io.IOException;

/**
 *
 * @author Rajat
 */
public class ChatApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Start Of The Program");
        Server.runServer();
        System.out.println("End Of The Program");
    }
}
