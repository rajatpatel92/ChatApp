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
public class ChatApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Start Of The Program");
        Server.run();
        System.out.println("End Of The Program");
    }
}
