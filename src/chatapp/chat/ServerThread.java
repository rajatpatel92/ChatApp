/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.chat;

/**
 *
 * @author Rajat
 */
public class ServerThread implements Runnable {
    Thread t1, t2;
    OpenServerChat osc;
    OpenClientChat occ;
    public ServerThread(String type){
        switch (type){
            case "toClient":
                t1 = new Thread(this, type);
                t1.start();
                break;
            case "fromClient":
                t2 = new Thread(this, type);
                t2.start();
                break;
        }
    }
    @Override
    public void run() {
        
    }
    
}
