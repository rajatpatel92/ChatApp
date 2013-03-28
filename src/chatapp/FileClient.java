
package chatapp;

import java.io.IOException;

/**
 *
 * @author Rajat
 */
public class FileClient {
    public static void main (String[] args) throws IOException{
        FileFunctions ff = new FileFunctions("Client");
        ff.receiveFilefromServer("receivedFile.txt");
    } 
}
