
package chatapp;

import java.io.*;
import java.net.UnknownHostException;

/**
 *
 * @author Rajat
 */
public class FileFunctions {
    private FileOutputStream fos;
    OpenServerStreams oss;
    OpenClientStreams ocs;
    int bytesRead;
    int current = 0;
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
        //oss.os.flush();
        System.out.println("File Sent Successfully!!");
    }
    public void receiveFilefromServer(String fn) throws IOException{
        File file = new File(fn);
        fos = new FileOutputStream(file);
        System.out.println("Receiving File..");
        byte [] mybytearray  = new byte [(int)file.length()];
        BufferedOutputStream bos = new BufferedOutputStream(fos);
            bytesRead = ocs.is.read(mybytearray,0,mybytearray.length);
            current = bytesRead;
            do {
                bytesRead =
                        ocs.is.read(mybytearray, current, (mybytearray.length-current));
                if(bytesRead >= 0) current += bytesRead;
            } while(bytesRead > -1);
            bos.write(mybytearray, 0 , current);
            bos.flush();
            System.out.println("File received successfully..\nClosing Connection...");
        ocs.clientSocket.close();
        System.out.println("Connection Closed");
        }
    public void receiveFilefromClient(String fn) throws IOException{
        
    }
}
