
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
    
    FileFunctions(String a) throws IOException{
        switch (a) {
            case "Server":
                oss =  new OpenServerStreams();
                
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
        while(true){
            oss.openStreams();
            File myFile = new File (fName);
            byte [] mybytearray  = new byte [(int)myFile.length()];
            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(mybytearray,0,mybytearray.length);
            System.out.println("Sending...");
            oss.os.write(mybytearray,0,mybytearray.length);
            oss.os.flush();
            System.out.println("File Sent Successfully!!");
        }
    }
    public void receiveFilefromServer(String fn) throws IOException{
        int bytesRead;
        int current = 0;
        int filesize=6022386;
        File file = new File(fn);
        fos = new FileOutputStream(file);
        System.out.println("Receiving File..");
        byte [] mybytearray  = new byte [filesize];
        System.out.println("Step 1");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        System.out.println("Step 2");
        bytesRead = ocs.is.read(mybytearray,0,mybytearray.length);
        System.out.println("Step 3");
        current = bytesRead;
        System.out.println("Step 3");
        do {
            bytesRead = ocs.is.read(mybytearray, current, (mybytearray.length-current));
            System.out.println(bytesRead);
            if(bytesRead >= 0) current += bytesRead;
            System.out.println(current);
        } while(bytesRead > -1);
        System.out.println("Step 4");
        bos.write(mybytearray, 0 , current);
        System.out.println("Step 5");
        bos.flush();
        System.out.println("Step 6");
        System.out.println("File received successfully..\nClosing Connection...");
        ocs.clientSocket.close();
        System.out.println("Connection Closed");
        }
    public void receiveFilefromClient(String fn) throws IOException{
        
    }
}
