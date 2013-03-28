/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.IOException;

/**
 *
 * @author Rajat
 */
public class FileServer {
    //private ServerSocket serverSocket;
    //private Socket socket;
    //private ByteArrayOutputStream out;
    //private InputStreamReader in;
    public void run() throws IOException{
		FileFunctions ff = new FileFunctions("Server");
                ff.sendFiletoClient("toClient.txt");
	}
            //}
        } 
 
