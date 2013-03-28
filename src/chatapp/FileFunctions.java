/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.*;
import java.net.UnknownHostException;

/**
 *
 * @author Rajat
 */
public class FileFunctions {
    //private FileInputStream is;
    private FileOutputStream fos;
    //private InputStreamReader in;
    OpenServerStreams oss;
    OpenClientStreams ocs;
	//int filesize=6022386; 
    int bytesRead;
    int current = 0;
    //private ByteArrayOutputStream out;
    FileFunctions(String a) throws IOException{
        switch (a) {
            case "Server":
                oss =  new OpenServerStreams();
                oss.openStreams();
                break;
            case "Client":
                ocs = new OpenClientStreams();
                ocs.openStreams();
                break;
        }
    }
    public void sendFiletoServer(File fName) throws UnknownHostException, IOException{
        
    }
    public void sendFiletoClient(String fName) throws UnknownHostException, IOException{
		  File myFile = new File (fName);
		  byte [] mybytearray  = new byte [(int)myFile.length()];
		  FileInputStream fis = new FileInputStream(myFile);
		  BufferedInputStream bis = new BufferedInputStream(fis);
		  bis.read(mybytearray,0,mybytearray.length);
		  System.out.println("Sending...");
		  oss.os.write(mybytearray,0,mybytearray.length);
		  oss.os.flush();
    }
    public void receiveFilefromServer(String fn) throws IOException{
                File file = new File(fn);
		fos = new FileOutputStream(file);
                byte [] mybytearray  = new byte [(int)file.length()];
		BufferedOutputStream bos = new BufferedOutputStream(fos);
                //InputStream is = sock.getInputStream();
		bytesRead = ocs.is.read(mybytearray,0,mybytearray.length);
		current = bytesRead;
		do {
		   bytesRead =
			  ocs.is.read(mybytearray, current, (mybytearray.length-current));
		   if(bytesRead >= 0) current += bytesRead;
		} while(bytesRead > -1);
		bos.write(mybytearray, 0 , current);
		bos.flush();
		bos.close();
                ocs.clientSocket.close();
		}
    public void receiveFilefromClient(String fn) throws IOException{
        
    }
}