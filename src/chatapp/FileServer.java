
package chatapp;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Rajat
 */
public class FileServer {
    static Scanner sc;
    public static void main(String[] args) throws IOException{
        sc = new Scanner (System.in);
        while (true){
            FileFunctions ff = new FileFunctions("Server");
            System.out.println("Enter name or path of the file to be sent :");
            String fileName = sc.nextLine();
            //byte[] name = fileName.getBytes();
            //ff.oss.os.write(name);
            //ff.oss.os.flush();
            ff.sendFiletoClient(fileName);
        }
    }
}
 
