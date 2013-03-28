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
public class FileSharingServer {
    public static void main(String[] args) throws IOException{
        while(true){
            FileServer fs = new FileServer();
            fs.run();
        }
    }
}
