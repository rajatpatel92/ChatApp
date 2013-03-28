/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Rajat
 */
public class FileClient {
    //private Socket clientSocket;
    //private ByteArrayOutputStream out;
    //private InputStreamReader in;
    //private FileInputStream fis;
    //private FileOutputStream fos;
    public void run() throws IOException{
            FileFunctions ff = new FileFunctions("Client");
            ff.receiveFilefromServer("fromServer.txt");
    } 
}
