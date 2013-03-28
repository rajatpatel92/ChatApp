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
public class FileSharingClient {
    public static void main(String[] args) throws IOException{
            FileClient fc = new FileClient();
            fc.run();
    }
}
